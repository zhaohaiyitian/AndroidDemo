package com.wj.wjnews.net.http;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 上层的业务请求对象
 * Created by wj on 18-5-7.
 */

public class Request {
    public static final String ENCODING="utf-8";

    private String mUrl;

    private HttpMethod mMethod;

    private HttpHeader mHeader;

    private byte[] data;

    public Request(Builder builder) {
        this.mUrl=builder.mUrl;
        this.mMethod=builder.mMethod;
        this.mHeader=builder.mHeader;
        this.data=encodeParam(builder.mFormParams);

    }

    public static class Builder {
        private String mUrl;
        private HttpMethod mMethod;
        private HttpHeader mHeader;
        private Map<String,String> mFormParams=new HashMap<>();
        private Map<String,String> mQueryParams=new HashMap<>();
        private Builder url(String url) {
            this.mUrl=url;
            return this;
        }
        private Builder addMethod(HttpMethod method) {
            this.mMethod=method;
            return this;
        }
        private Builder addHeader(HttpHeader header) {
            this.mHeader=header;
            return this;
        }
        private Builder addFormParam(String key,String value) {
            mFormParams.put(key,value);
            return this;
        }
        private Builder addQueryParam(String key,String value) {
            mQueryParams.put(key,value);
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }


    public static byte[] encodeParam(Map<String,String> value) {
        if (value==null||value.size()==0) {
            return null;
        }
        StringBuffer buffer=new StringBuffer();
        int count=0;
        for (Map.Entry<String, String> entry : value.entrySet()) {
            try {
                buffer.append(URLEncoder.encode(entry.getKey(),ENCODING))
                        .append("=")
                        .append(URLEncoder.encode(entry.getValue(),ENCODING));
                if (count!=value.size()-1) {
                    buffer.append("&");
                }
                count++;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString().getBytes();
    }


    public String getmUrl() {
        return mUrl;
    }

    public HttpMethod getmMethod() {
        return mMethod;
    }

    public HttpHeader getmHeader() {
        return mHeader;
    }

    public byte[] getData() {
        return data;
    }
}
