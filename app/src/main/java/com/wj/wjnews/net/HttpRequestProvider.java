package com.wj.wjnews.net;

import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.http.HttpRequest;
import com.wj.wjnews.utils.StringUtil;

import java.io.IOException;
import java.net.URI;

/**
 * Created by wj on 18-5-5.
 */

public class HttpRequestProvider {

    private HttpRequestFactory mHttpRequestFactory;
    //是否支持OkHttp
    private static boolean OKHTTP_REQUEST= StringUtil.isExit("okhttp3.OkHttpClient",HttpRequestProvider.class.getClassLoader());
    public HttpRequestProvider() {
        if (OKHTTP_REQUEST) {
            mHttpRequestFactory=new OkHttpRequestFactory();
        } else {
            mHttpRequestFactory=new OriginHttpRequestFactory();
        }
    }

    public HttpRequest getHttpRequest(URI uri, HttpMethod method) throws IOException {
        return mHttpRequestFactory.createHttpRequest(uri,method);
    }

    public HttpRequestFactory getmHttpRequestFactory() {
        return mHttpRequestFactory;
    }

    public void setmHttpRequestFactory(HttpRequestFactory mHttpRequestFactory) {
        this.mHttpRequestFactory = mHttpRequestFactory;
    }
}
