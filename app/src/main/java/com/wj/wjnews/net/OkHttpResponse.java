package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpHeader;
import com.wj.wjnews.net.http.HttpStatus;

import java.io.InputStream;

import okhttp3.Response;

/**
 * Created by wj on 18-5-5.
 */

public class OkHttpResponse extends AbstractHttpResponse {
    private Response mResponse;
    private HttpHeader mHeaders;
    public OkHttpResponse(Response response) {
        this.mResponse = response;
    }

    @Override
    public HttpHeader getHeaders() {
        if (mHeaders==null) {
            mHeaders=new HttpHeader();
        }
        for (String name : mResponse.headers().names()) {
            mHeaders.set(name,mResponse.headers().get(name));
        }
        return mHeaders;
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.getValue(mResponse.code());
    }

    @Override
    public String getStatusMsg() {
        return mResponse.message();
    }

    @Override
    public long getContentLength() {
        return mResponse.body().contentLength();
    }

    @Override
    protected InputStream getBodyInternal() {
        return mResponse.body().byteStream();
    }

    @Override
    protected void closeInternal() {
        mResponse.body().close();
    }
}
