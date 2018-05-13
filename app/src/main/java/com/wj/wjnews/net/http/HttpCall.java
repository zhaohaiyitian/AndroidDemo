package com.wj.wjnews.net.http;

import com.wj.wjnews.net.HttpRequestProvider;
import com.wj.wjnews.net.http.client.CallBack;
import com.wj.wjnews.net.service.convert.Convert;
import com.wj.wjnews.utils.TypeUtil;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by wj on 18-5-7.
 */

public class HttpCall implements HttpEngine {

    private Request mRequest;
    private ExecutorService executorService;
    private List<Convert> converts;
    HttpRequestProvider provider;
    private CallBack callBack;
    private NiceClient mNiceClient;

    public HttpCall(Request mRequest, NiceClient mNiceClient,CallBack callBack) {
        this.mRequest = mRequest;
        this.callBack = callBack;
        this.mNiceClient = mNiceClient;
    }

    public HttpCall(Request request, ExecutorService executorService, List<Convert> converts, HttpRequestProvider provider, CallBack callBack) {
        this.mRequest = request;
        this.executorService = executorService;
        this.converts = converts;
        this.provider = provider;
        this.callBack = callBack;
    }

    @Override
    public HttpResponse execute() throws IOException {
        HttpRequest request;
        request=provider.getHttpRequest(URI.create(mRequest.getmUrl()),mRequest.getMethod());
        request.setHeaders(mRequest.getmHeader());
        if (mRequest.getData()!=null) {
            request.getBody().write(mRequest.getData());
        }
        return request.execute();
    }

    public <T> T invoke(Class<T> resposneType) {
        Type type = TypeUtil.getType(resposneType);
        HttpResponse response;
        T result=null;
        try {
            response=execute();
            if (!response.getStatus().isSuccess()) {
                fail(response.getStatusMsg());
                return null;
            }
            result=convertResponse(response,type);
            if (result==null) {
                fail("result is null");
                return null;
            }
           T resposne= parseResposne(result,response);
            success((Response) response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private <T> T parseResposne(T result,HttpResponse response) {
        return (T) new Response(result,response);
    }

    public <T> T convertResponse(HttpResponse response,Type type) throws IOException {
        for (Convert convert : converts) {
           return (T) convert.parse(response,type);
        }
        return null;
    }


    public <T>Future<T> invoke() {
        //往线程池提交任务
        return executorService.submit(new Callable<T>() {
            @Override
            public T call() throws Exception {//执行请求
                return invoke(null);
            }
        });
    }

    private void success(Response response) {
        callBack.onSuccess(response);
    }

    private void fail(String errorMsg) {
        callBack.onFailure(errorMsg);

    }
}
