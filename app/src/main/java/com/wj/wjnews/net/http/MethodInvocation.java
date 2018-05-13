package com.wj.wjnews.net.http;

import com.wj.wjnews.net.http.client.CallBack;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

/**
 * Created by wj on 18-5-9.
 */

public class MethodInvocation implements InvocationHandler {

    private NiceClient mNiceClient;
    private HashMap<Method, MethodAnnotationProcess> mMethodCache;

    public MethodInvocation(NiceClient mNiceClient, HashMap<Method, MethodAnnotationProcess> mMethodCache) {
        this.mNiceClient = mNiceClient;
        this.mMethodCache = mMethodCache;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (args==null||args.length==0) {
            throw new IllegalArgumentException("args is not null");
        }
        if (!(args[args.length-1] instanceof CallBack)) {
            throw new IllegalArgumentException("最后一个参数必须是Callback类型");
        }
        execute(args,mMethodCache.get(method),(CallBack) args[args.length-1]);
        return null;
    }

    private void execute(Object[] args,MethodAnnotationProcess process,CallBack callBack) throws UnsupportedEncodingException, ExecutionException, InterruptedException {
        Request request=process.buildRequest(args);
        HttpCall httpCall=new HttpCall(request,mNiceClient,callBack);
        httpCall.invoke().get();
    }
}
