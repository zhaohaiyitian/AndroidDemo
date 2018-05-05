package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpHeader;
import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.HttpResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.util.Map;

/**
 * Created by wj on 18-5-5.
 */

public class OriginHttpRequest extends BufferHttpRequest {

    private HttpURLConnection mConnection;
    private String mUrl;
    private HttpMethod mMethod;

    public OriginHttpRequest(HttpURLConnection mConnection, String mUrl, HttpMethod mMethod) {
        this.mConnection = mConnection;
        this.mUrl = mUrl;
        this.mMethod = mMethod;
    }

    @Override
    protected HttpResponse executeInternal(HttpHeader header, byte[] data) throws IOException {
        for (Map.Entry<String, String> entry : header.entrySet()) {
            mConnection.addRequestProperty(entry.getKey(),entry.getValue());
        }
        mConnection.setDoInput(true);
        mConnection.setDoOutput(true);
        mConnection.setRequestMethod(mMethod.name());
        mConnection.connect();
        if (data!=null&&data.length>0) {
            OutputStream outputStream = mConnection.getOutputStream();
            outputStream.write(data,0,data.length);
            outputStream.close();
        }
        return new OriginHttpResponse(mConnection);
    }

    @Override
    public HttpMethod getMethod() {
        return mMethod;
    }

    @Override
    public URI getUri() {
        return URI.create(mUrl);
    }
}
