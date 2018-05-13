package com.wj.wjnews.net.http;

import com.wj.wjnews.net.HttpRequestProvider;
import com.wj.wjnews.net.service.convert.Convert;
import com.wj.wjnews.net.service.convert.JsonConvert;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by wj on 18-5-8.
 */

public class NiceClient {

    private String mUrl;
    private ExecutorService mExecutor;
    private List<Convert> mConverts;
    private HttpRequestProvider mProvider;

    public NiceClient(Builder builder) {
        this.mUrl = builder.mUrl;
        this.mConverts = builder.mConverts;
        this.mExecutor = builder.mExecutor;
        this.mProvider=builder.mProvider;
    }

    public String getUrl() {
        return mUrl;
    }

    public ExecutorService getExecutor() {
        return mExecutor;
    }

    public List<Convert> getConverts() {

        return mConverts;
    }

    public HttpRequestProvider getProvider() {
        return mProvider;
    }

    public static class Builder {
        public static final int CONNECTION_TIME_OUT = 3000;
        public static final int READER_TIME_OUT = 3000;
        public static final int WRITE_TIME_OUT = 3000;
        private String mUrl;
        private ExecutorService mExecutor;
        private List<Convert> mConverts;
        private HttpRequestProvider mProvider;
        public Builder url(String url) {
            this.mUrl = url;
            return this;
        }

        public Builder executor(ExecutorService executorService) {
            this.mExecutor = executorService;
            return this;
        }

        public NiceClient build() {
            if (mProvider==null) {
                mProvider=new HttpRequestProvider();
            }
            if (mConverts==null) {
                mConverts=new ArrayList<>();
                mConverts.add(new JsonConvert());
            }
            return new NiceClient(this);
        }
    }

    public <T> T create(Class clazz) {
        if (!clazz.isInterface()) {
            throw new RuntimeException("clazz 必须是接口类型");
        }
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });

    }
}
