package com.wj.wjnews.download;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.wj.wjnews.R;
import com.wj.wjnews.utils.Logger;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DownloadActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        imageView = (ImageView) findViewById(R.id.image);
        findViewById(R.id.download).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        download();
                    }
                }).start();
            }
        });
//        File file = FileStorageManager.getInstance().getFileByName("http://www.imooc.com");
//        Logger.d("wangjie","path: "+file.getAbsoluteFile());

    }

    private void download() {
        DownloadManager.getInstance().download("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1525074695796&di=d74fe5730a38893160397e6e097bb852&imgtype=0&src=http%3A%2F%2Fimg1c.xgo-img.com.cn%2Fpics%2F1686%2F1685723.jpg", new DownloadCallBack() {
            @Override
            public void success(File file) {
                Logger.d("wang  ",file.getAbsolutePath());
                final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }

            @Override
            public void fail(int errorCode, String errorMessage) {
                Logger.d("wangjie","fail " +errorCode+" "+errorMessage);
            }

            @Override
            public void progress(int progress) {

            }
        });
//        HttpManager.getInstance().asyncRequest("", new DownloadCallBack() {
//            @Override
//            public void success(File file) {
//                final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        imageView.setImageBitmap(bitmap);
//                    }
//                });
//
//                Logger.d("wangjie","success: "+file.getAbsoluteFile());
//            }
//
//            @Override
//            public void fail(int errorCode, String errorMessage) {
//                Logger.d("wangjie","fail: "+errorCode+" : "+errorMessage);
//            }
//
//            @Override
//            public void progress(int progress) {
//
//            }
//        });

//        OkHttpClient okHttpClient=new OkHttpClient();
//        Request request=new Request.Builder()
//                .url("")
//                .addHeader("Range","bytes=0-")
//                .build();
//        Call call = okHttpClient.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.d("wangjie","content-length； "+response.body().contentLength());
//                if (response.isSuccessful()) {
//                    Headers headers = response.headers();
//                    for (int i = 0; i < headers.size(); i++) {
//                        Log.d("wangjie",headers.name(i)+" ::: "+headers.value(i));
//                    }
//                }
//            }
//        });
    }
}
