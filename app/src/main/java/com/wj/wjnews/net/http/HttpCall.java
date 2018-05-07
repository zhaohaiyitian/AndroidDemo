package com.wj.wjnews.net.http;

import com.wj.wjnews.net.HttpRequestProvider;
import com.wj.wjnews.net.http.client.CallBack;
import com.wj.wjnews.net.service.convert.Convert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by wj on 18-5-7.
 */

public class HttpCall implements HttpEngine {

    private HttpMethod method;
    private ExecutorService executorService;
    private List<Convert> converts;
    HttpRequestProvider provider;
    private CallBack callBack;

    public HttpCall(HttpMethod method, ExecutorService executorService, List<Convert> converts, HttpRequestProvider provider, CallBack callBack) {
        this.method = method;
        this.executorService = executorService;
        this.converts = converts;
        this.provider = provider;
        this.callBack = callBack;
    }

    @Override
    public HttpResponse execute() throws IOException {
        HttpRequest request;

        return null;
    }
}
