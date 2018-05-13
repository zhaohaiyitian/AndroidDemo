package com.wj.wjnews.net.process;

import com.wj.wjnews.net.http.Request;

/**
 * Created by wj on 18-5-10.
 */

public class BodyParamAnnotationProcess extends ParamAnnotationProcess<String,Object> {

    public BodyParamAnnotationProcess(Request.Builder builder, String mAnnotationValue) {
        super(builder, mAnnotationValue);
    }

    @Override
    void process(Object args) {

    }
}
