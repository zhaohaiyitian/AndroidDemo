package com.wj.wjnews.net.http;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

/**
 * Created by wj on 18-5-5.
 */

public interface HttpRequest extends Header {
    HttpMethod getMethod();
    URI getUri();
    OutputStream getBody();
    HttpResponse execute() throws IOException;

    /**
     * 设置http请求头
     * @param httpHeader
     */
    void setHeaders(HttpHeader httpHeader);
}
