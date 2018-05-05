package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpHeader;
import com.wj.wjnews.net.http.HttpResponse;
import com.wj.wjnews.net.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wj on 18-5-5.
 */

public class OriginHttpResponse implements HttpResponse {
    @Override
    public HttpHeader getHeaders() {
        return null;
    }

    @Override
    public HttpStatus getStatus() {
        return null;
    }

    @Override
    public String getStatusMsg() {
        return null;
    }

    @Override
    public InputStream getBody() throws IOException {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public long getContentLength() {
        return 0;
    }
}
