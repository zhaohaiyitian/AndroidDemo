package com.wj.wjnews.download.http;

import android.content.Context;

import com.wj.wjnews.download.file.FileStorageManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by wj on 18-4-30.
 */

public class HttpManager {
    public static final int NETWPRK_CODE = 1;
    public static final int HTTP_LENGTH_ERROR_CODE=2;
    public static final int TASK_RUNNING_ERROR_CODE=3;
    private static HttpManager instance=new HttpManager();
    private Context mContext;
    private OkHttpClient mClient=new OkHttpClient();
    private HttpManager(){
        mClient=new OkHttpClient();
    }
    public static HttpManager getInstance() {
        return instance;
    }

    public void init(Context context) {
        this.mContext=context;
    }

    public Response syncRequest(String url) {
        Request request = new Request.Builder().url(url).build();
        try {
            return mClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response syncRequestByRange(String url,long start,long end) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Range","bytes="+start+"-"+end)
                .build();
        try {
            return mClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void asyncRequest(String url,Callback callback) {
        Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(callback);
    }

    public void asyncRequest(final String url, final DownloadCallBack callback) {
        Request request=new Request.Builder()
                .url(url).build();
        Call call = mClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()&&callback!=null) {
                    callback.fail(NETWPRK_CODE,"请求失败");
                }
                File file = FileStorageManager.getInstance().getFileByName(url);
                byte[] buffer=new byte[1024*500];
                int len;
                FileOutputStream fileOut=new FileOutputStream(file);
                InputStream inputStream=response.body().byteStream();
                while((len=inputStream.read(buffer,0,buffer.length))!=-1) {
                    fileOut.write(buffer,0,len);
                    fileOut.flush();
                }
                inputStream.close();
                fileOut.close();
                callback.success(file);

            }
        });
    }
}
