package com.wj.wjnews.application;

import android.app.Application;

import com.wj.wjnews.download.FileStorageManager;
import com.wj.wjnews.download.HttpManager;
import com.wj.wjnews.utils.Logger;

import java.io.File;

/**
 * Created by wj on 18-4-30.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FileStorageManager.getInstance().init(this);
        HttpManager.getInstance().init(this);
    }
}
