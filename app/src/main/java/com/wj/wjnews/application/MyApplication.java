package com.wj.wjnews.application;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.wj.wjnews.download.db.DownloadHelper;
import com.wj.wjnews.download.file.FileStorageManager;
import com.wj.wjnews.download.http.HttpManager;

/**
 * Created by wj on 18-4-30.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileStorageManager.getInstance().init(this);
        HttpManager.getInstance().init(this);
        DownloadHelper.getInstance().init(this);
        Stetho.initializeWithDefaults(this);
    }
}
