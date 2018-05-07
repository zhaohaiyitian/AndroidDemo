package com.wj.wjnews.net.service;

import com.wj.wjnews.net.http.HttpMethod;

/**
 * @deprecated
 * Created by wj on 18-5-6.
 */

public class WjRequest {
    private String mUrl;
    private HttpMethod mMethod;
    private byte[] mData;
    private WjResponse mResponse;
    private String mContentType;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl  ;
    }

    public HttpMethod getMethod() {
        return mMethod;
    }

    public void setMethod(HttpMethod mMethod) {
        this.mMethod = mMethod;
    }

    public byte[] getData() {
        return mData;
    }

    public void setData(byte[] mData) {
        this.mData = mData;
    }

    public WjResponse getResposne() {
        return mResponse;
    }

    public void setResposne(WjResponse mResponse) {
        this.mResponse = mResponse;
    }

    public String getContentType() {
        return mContentType;
    }

    public void setContentType(String mContentType) {
        this.mContentType = mContentType;
    }
}
