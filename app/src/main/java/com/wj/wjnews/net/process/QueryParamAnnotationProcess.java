package com.wj.wjnews.net.process;

import com.wj.wjnews.net.http.Request;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by wj on 18-5-10.
 */

public class QueryParamAnnotationProcess extends ParamAnnotationProcess<String,Object> {
    public static final String ENCODING="utf-8";
    private boolean mEncoded;
    public QueryParamAnnotationProcess(Request.Builder builder, String mAnnotationValue,boolean encoded) {
        super(builder, mAnnotationValue);
        this.mEncoded=encoded;
    }

    @Override
    void process(Object args) throws UnsupportedEncodingException {
        mBuilder.addFormParam(mAnnotationValue,mEncoded? URLEncoder.encode(String.valueOf(args),ENCODING):(String)args);
    }
}
