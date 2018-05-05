package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.HttpRequest;

import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by wj on 18-5-5.
 */

public class OkHttpRequestFactory implements HttpRequestFactory {
    private OkHttpClient mClient;

    public OkHttpRequestFactory() {
        this.mClient = new OkHttpClient();
    }

    public OkHttpRequestFactory(OkHttpClient mClient) {
        this.mClient = mClient;
    }

    public void setReadTimeOut(int readTimeOut) {
        this.mClient=mClient.newBuilder().readTimeout(readTimeOut, TimeUnit.MILLISECONDS).build();
    }

    public void setWriteTimeOut(int writeTimeOut) {
        this.mClient = mClient.newBuilder().
                writeTimeout(writeTimeOut, TimeUnit.MILLISECONDS).
                build();
    }

    public void setConnectionTimeOut(int connectionTimeOut) {
        this.mClient = mClient.newBuilder().
                connectTimeout(connectionTimeOut, TimeUnit.MILLISECONDS).
                build();
    }
    @Override
    public HttpRequest createHttpRequest(URI uri, HttpMethod method)  {
        return new OkHttpRequest(mClient,method,uri.toString());
    }
}
