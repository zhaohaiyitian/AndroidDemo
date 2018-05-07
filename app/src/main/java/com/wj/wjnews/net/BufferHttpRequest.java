package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpHeader;
import com.wj.wjnews.net.http.HttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by wj on 18-5-5.
 */

public abstract class BufferHttpRequest extends AbstractHttpRequest{

    private ByteArrayOutputStream mByteArray=new ByteArrayOutputStream();
    protected OutputStream getBodyOutputStream() {
        return mByteArray;
    }

    @Override
    protected HttpResponse executeInternal(HttpHeader header) throws IOException {
        byte[] data=mByteArray.toByteArray();
        return executeInternal(header,data);
    }

    protected abstract HttpResponse executeInternal(HttpHeader header, byte[] data) throws IOException;

}
