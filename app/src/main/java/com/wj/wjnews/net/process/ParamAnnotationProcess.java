package com.wj.wjnews.net.process;

import com.wj.wjnews.net.http.Request;

import java.io.UnsupportedEncodingException;

/**
 * Created by wj on 18-5-8.
 */

public abstract class ParamAnnotationProcess<T,K> {
    /**
     * 网络请求构建者
     */
    protected Request.Builder mBuilder;
    /**
     * Annotation的值
     */
    protected T mAnnotationValue;

    public ParamAnnotationProcess(Request.Builder builder, T mAnnotationValue) {
        this.mBuilder = builder;
        this.mAnnotationValue = mAnnotationValue;
    }

    public abstract void process(K args) throws UnsupportedEncodingException;
}
