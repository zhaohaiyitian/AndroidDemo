package com.wj.wjnews.net.http;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wj on 18-5-5.
 */

public interface HttpResponse extends Header,Closeable {

    HttpStatus getStatus();
    String getStatusMsg();
    InputStream getBody() throws IOException;
    void close();
    long getContentLength();
}
