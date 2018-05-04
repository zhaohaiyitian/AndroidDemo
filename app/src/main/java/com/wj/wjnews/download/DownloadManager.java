package com.wj.wjnews.download;

import android.support.annotation.NonNull;

import com.wj.wjnews.download.db.DownloadEntity;
import com.wj.wjnews.download.db.DownloadHelper;
import com.wj.wjnews.download.file.FileStorageManager;
import com.wj.wjnews.download.http.DownloadCallBack;
import com.wj.wjnews.download.http.HttpManager;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by wj on 18-4-30.
 */

public class DownloadManager {
    private static DownloadManager instance=new DownloadManager();
    private static final ExecutorService localProgressPool= Executors.newFixedThreadPool(1);
    private static final int MAX_THREAD=2;
    private HashSet<DownloadTask> mHashSet=new HashSet<>();
    private static final ThreadPoolExecutor sThreadPool=new ThreadPoolExecutor(
            MAX_THREAD, MAX_THREAD, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(),
            new ThreadFactory() {
                @Override
                public Thread newThread(@NonNull Runnable r) {
                    AtomicInteger integer=new AtomicInteger(1);
                    Thread thread=new Thread(r,"dowload thread# "+integer.getAndIncrement());
                    return thread;
                }
            });
    private List<DownloadEntity> mCache;
    private long mLength;

    private DownloadManager() {
    }
    public static DownloadManager getInstance() {
        return instance;
    }
    private void finish(DownloadTask task) {
        mHashSet.remove(task);
    }
    public void download(final String url, final DownloadCallBack callBack) {
         final DownloadTask task=new DownloadTask(url,callBack);
        if (mHashSet.contains(task)){
            callBack.fail(HttpManager.TASK_RUNNING_ERROR_CODE,"任务已经提交了");
            return;
        }
        mHashSet.add(task);
        mCache = DownloadHelper.getInstance().getAll(url);
        if (mCache==null||mCache.size()==0) {
            HttpManager.getInstance().asyncRequest(url, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    finish(task);
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    if (!response.isSuccessful()&&callBack!=null) {
                        callBack.fail(HttpManager.NETWPRK_CODE,"网络出问题了");
                        return;
                    }
                    mLength = response.body().contentLength();
                    if (mLength ==-1) {
                        callBack.fail(HttpManager.HTTP_LENGTH_ERROR_CODE,"content length -1");
                        return;
                    }
                    processDownload(url, mLength,callBack,mCache);
                    finish(task);
                }
            });
        } else {
            //处理已经下载过的数据
            for (int i = 0; i < mCache.size(); i++) {
                DownloadEntity entity = mCache.get(i);
                if (i==mCache.size()-1) {
                    mLength=entity.getEnd_position()+1;
                }
                long startSize=entity.getStart_position()+entity.getProgress_position();
                long endSize=entity.getEnd_position();
                sThreadPool.execute(new DownloadRunnable(startSize,endSize,url,callBack,entity));
            }
        }

        localProgressPool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                        File file = FileStorageManager.getInstance().getFileByName(url);
                        long fileSize = file.length();
                        int progress=(int)(fileSize*100/mLength);
                        if (progress>=100) {
                            callBack.progress(progress);
                            return;
                        }
                        callBack.progress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void processDownload(String url,long length,DownloadCallBack callback,List<DownloadEntity> cache) {
        long threadDownloadSize=length/MAX_THREAD;
        if (cache==null||cache.size()==0){
            mCache=new ArrayList<>();
        }
        for (int i = 0; i < MAX_THREAD; i++) {
            DownloadEntity entity=new DownloadEntity();
            long endSize=0;
            long startSize=i*threadDownloadSize;
            if (i==MAX_THREAD-1) {
                endSize=length-1;
            } else {
                endSize=(i+1)*threadDownloadSize-1;
            }
            entity.setDownload_url(url);
            entity.setStart_position(startSize);
            entity.setEnd_position(endSize);
            entity.setThread_id(i+1);
            sThreadPool.execute(new DownloadRunnable(startSize,endSize,url,callback,entity));
        }

    }


}
