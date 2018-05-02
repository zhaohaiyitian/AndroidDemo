package com.wj.wjnews.download;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.Response;

/**
 * Created by wj on 18-4-30.
 *  线程下载核心类
 */

public class DownloadRunnable implements Runnable {
    private long mStart,mEnd;
    private String mUrl;
    private DownloadCallBack mCallBack;

    public DownloadRunnable(long mStart, long mEnd, String mUrl, DownloadCallBack mCallBack) {
        this.mStart = mStart;
        this.mEnd = mEnd;
        this.mUrl = mUrl;
        this.mCallBack = mCallBack;
    }

    public DownloadRunnable(long mStart, long mEnd, String mUrl) {
        this.mStart = mStart;
        this.mEnd = mEnd;
        this.mUrl = mUrl;
    }

    @Override
    public void run() {
        Response response = HttpManager.getInstance().syncRequestByRange(mUrl, mStart, mEnd);
        if (response==null&&mCallBack!=null) {
            mCallBack.fail(HttpManager.NETWPRK_CODE,"网络出问题了");
            return;
        }
        File file = FileStorageManager.getInstance().getFileByName(mUrl);
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rwd");
            randomAccessFile.seek(mStart);
            byte[] buffer=new byte[1024*500];
            int len;
            InputStream inputStream=response.body().byteStream();
            while ((len=inputStream.read(buffer,0,buffer.length))!=-1) {
                randomAccessFile.write(buffer,0,len);
            }
            randomAccessFile.close();
            mCallBack.success(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
