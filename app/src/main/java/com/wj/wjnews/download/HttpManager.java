package com.wj.wjnews.download;

import android.content.Context;

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
    private static final int NETWPRK_CODE = 1;
    private static HttpManager instance=new HttpManager();
    private Context mContext;
    private OkHttpClient client=new OkHttpClient();
    private HttpManager(){
        client=new OkHttpClient();
    }
    public static HttpManager getInstance() {
        return instance;
    }

    public void init(Context context) {
        this.mContext=context;
    }

    public void asyncRequest(final String url, final DownloadCallBack callback) {
        Request request=new Request.Builder().url(url).build();
        Call call = client.newCall(request);
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
