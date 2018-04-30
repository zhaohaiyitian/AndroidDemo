package com.wj.wjnews.download;

import android.support.annotation.NonNull;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wj on 18-4-30.
 */

public class DownloadManager {
    private static DownloadManager instance=new DownloadManager();
    private static final int MAX_THREAD=2;
    private static final ThreadPoolExecutor sThreadPool=new ThreadPoolExecutor(
            MAX_THREAD, MAX_THREAD, 60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(),
            new ThreadFactory() {
                @Override
                public Thread newThread(@NonNull Runnable r) {
                    AtomicInteger integer=new AtomicInteger(1);
                    Thread thread=new Thread(r,"dowload thread# "+integer.getAndIncrement());
                    return thread;
                }
            });
    private DownloadManager() {
    }
    public static DownloadManager getInstance() {
        return instance;
    }
}
