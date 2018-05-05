package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpHeader;
import com.wj.wjnews.net.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by wj on 18-5-5.
 */

public class OriginHttpResponse extends AbstractHttpResponse {

    private HttpURLConnection mConnection;

    public OriginHttpResponse(HttpURLConnection mConnection) {
        this.mConnection = mConnection;
    }

    @Override
    public HttpHeader getHeaders() {
        HttpHeader httpHeader=new HttpHeader();
        for (Map.Entry<String, List<String>> entry : mConnection.getHeaderFields().entrySet()) {
            httpHeader.set(entry.getKey(),entry.getValue().get(0));
        }
        return httpHeader;
    }

    @Override
    public HttpStatus getStatus() {
        try {
            return HttpStatus.getValue(mConnection.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getStatusMsg() {
        try {
            return mConnection.getResponseMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected InputStream getBodyInternal() throws IOException {
        return mConnection.getInputStream();
    }

    @Override
    protected void closeInternal() {
        mConnection.disconnect();
    }

    @Override
    public long getContentLength() {
        return mConnection.getContentLength();
    }
}
