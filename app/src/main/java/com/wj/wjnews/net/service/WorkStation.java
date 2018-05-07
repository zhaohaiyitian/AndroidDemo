package com.wj.wjnews.net.service;

import android.support.annotation.NonNull;

import com.wj.wjnews.net.HttpRequestProvider;
import com.wj.wjnews.net.http.HttpRequest;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @deprecated
 * Created by wj on 18-5-6.
 */

public class WorkStation {
    public static final int MAX_REQUEST_SIZE=60;
    public static final ThreadPoolExecutor sThreadPool=new ThreadPoolExecutor(0, Integer.MAX_VALUE,
            60, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
        @Override
        public Thread newThread(@NonNull Runnable r) {
            AtomicInteger integer=new AtomicInteger(1);
            Thread thread=new Thread(r);
            thread.setName("http thread name is"+integer.getAndIncrement());
            return thread;
        }
    });
    //双端队列 头部和尾部都可以插入和删除
    private Deque<WjRequest> mRunning=new ArrayDeque<>();
    private Deque<WjRequest> mCache=new ArrayDeque<>();
    private HttpRequestProvider mRequestProvider;

    public WorkStation() {
        mRequestProvider=new HttpRequestProvider();
    }

    public void add(WjRequest request) {
        if (MAX_REQUEST_SIZE>60) {
            mCache.add(request);
        } else {
            doHttpRequest(request);
            mRunning.add(request);
        }

    }

    private void doHttpRequest(WjRequest request) {
        HttpRequest httpRequest=null;
        try {
            httpRequest=mRequestProvider.getHttpRequest(URI.create(request.getUrl()),request.getMethod());
        } catch (IOException e) {
            e.printStackTrace();
        }
        sThreadPool.execute(new HttpRunnable(httpRequest,request,this));
    }

    public void finish(WjRequest request) {
        mRunning.remove(request);
        if (mRunning.size()>MAX_REQUEST_SIZE) {
            return;
        }
        if (mCache.size()==0) {
            return;
        }
        Iterator<WjRequest> iterator = mCache.iterator();
        while (iterator.hasNext()) {
            WjRequest next=iterator.next();
            mRunning.add(next);
            iterator.remove();
            doHttpRequest(next);
        }
    }
}
