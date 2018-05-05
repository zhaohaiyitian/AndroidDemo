package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpHeader;
import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.HttpResponse;

import java.io.IOException;
import java.net.URI;

/**
 * Created by wj on 18-5-5.
 */

public class OriginHttpRequest extends BufferHttpRequest {
    @Override
    public HttpMethod getMethod() {
        return null;
    }

    @Override
    public URI getUri() {
        return null;
    }

    @Override
    protected HttpResponse executeInternal(HttpHeader header, byte[] data) throws IOException {
        return null;
    }
}
