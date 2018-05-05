package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.HttpRequest;

import java.net.URI;

/**
 * Created by wj on 18-5-5.
 */

public class OriginHttpRequestFactory implements HttpRequestFactory  {
    @Override
    public HttpRequest createHttpRequest(URI uri, HttpMethod method) {
        return null;
    }
}
