package com.wj.wjnews.net.http.client;

import com.wj.wjnews.net.http.HttpResponse;

import okhttp3.Request;

/**
 *
 * Created by wj on 18-5-6.
 */

public interface Call {
    HttpResponse execute(Request request);
}
