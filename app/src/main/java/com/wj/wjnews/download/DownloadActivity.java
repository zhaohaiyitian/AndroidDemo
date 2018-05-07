package com.wj.wjnews.download;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.wj.wjnews.R;
import com.wj.wjnews.download.http.DownloadCallBack;
import com.wj.wjnews.net.service.WjApiProvider;
import com.wj.wjnews.net.service.WjRequest;
import com.wj.wjnews.net.service.WjResponse;
import com.wj.wjnews.utils.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class DownloadActivity extends AppCompatActivity {

    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        imageView = (ImageView) findViewById(R.id.image);
        progressBar = (ProgressBar) findViewById(R.id.progress);
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
        Map<String, String> map = new HashMap<>();
        map.put("username","admin");
        map.put("password","admin");
        WjApiProvider.hello("http://www.baidu.com", null, new WjResponse<String>() {
            @Override
            public void success(WjRequest request, String data) {
                System.out.println(data);
            }

            @Override
            public void fail(int errorCode, String errorMsg) {
                System.out.println(errorCode+errorMsg);

            }
        });
//        DownloadManager.getInstance().download("http://shouji.360tpcdn.com/160901/84c090897cbf0158b498da0f42f73308/com.icoolme.android.weather_2016090200.apk", new DownloadCallBack() {
//            int count=0;
//            @Override
//            public void success(File file) {//success会回调两次????????????????
//                if (count<1) {
//                    count++;
//                    return;
//                }
//                Logger.d("wangjie","success "+file.getAbsolutePath());
//                installApk(file);
//
////                final Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
////                runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////                        imageView.setImageBitmap(bitmap);
////                    }
////                });
//            }
//
//            @Override
//            public void fail(int errorCode, String errorMessage) {
//                Logger.d("wangjie","fail " +errorCode+" "+errorMessage);
//            }
//
//            @Override
//            public void progress(int progress) {
//                Logger.d("zhongguo","progress "+progress);
//                progressBar.setProgress(progress);
//
//            }
//        });
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

    private void installApk(File file) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setDataAndType(Uri.parse("file://" + file.getAbsoluteFile().toString()), "application/vnd.android.package-archive");
        startActivity(intent);
    }
}
