package com.wj.wjnews.net.http;

import com.wj.wjnews.net.annotation.Body;
import com.wj.wjnews.net.annotation.DELETE;
import com.wj.wjnews.net.annotation.Field;
import com.wj.wjnews.net.annotation.FieldMap;
import com.wj.wjnews.net.annotation.GET;
import com.wj.wjnews.net.annotation.Header;
import com.wj.wjnews.net.annotation.POST;
import com.wj.wjnews.net.annotation.PUT;
import com.wj.wjnews.net.annotation.Path;
import com.wj.wjnews.net.annotation.Query;
import com.wj.wjnews.net.annotation.QueryMap;
import com.wj.wjnews.net.annotation.Retry;
import com.wj.wjnews.net.process.FieldParamAnnotationProcess;
import com.wj.wjnews.net.process.ParamAnnotationProcess;
import com.wj.wjnews.net.process.QueryParamAnnotationProcess;

import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wj on 18-5-9.
 * 注解处理类
 */

public class MethodAnnotationProcess {

    private Annotation[] mMethodAnotation;
    private Annotation[][] mMethodParamAnnotation;
    private NiceClient mNiceClient;
    private HttpMethod mHttpMethod;
    private HttpHeader mHeader;
    private String mPathUrl;
    private String mRealUrl;
    private Request.Builder mBuilder = new Request.Builder();
    private List<ParamAnnotationProcess> mAnnotationProcess=new ArrayList<>();
    public MethodAnnotationProcess(Method method,NiceClient mNiceClient) {
        mMethodAnotation=method.getAnnotations();
        mMethodParamAnnotation=method.getParameterAnnotations();
        this.mNiceClient = mNiceClient;
    }

    public void invoke() {
        for (Annotation annotation : mMethodAnotation) {
            processMethodAnnotation(annotation);
        }
        mRealUrl=mRealUrl+mPathUrl;
        for (int i = 0; i < mMethodParamAnnotation.length; i++) {
            Annotation[] paramAnnotation = mMethodParamAnnotation[i];
            if (paramAnnotation==null) {
                throw new RuntimeException("第"+i+"个参数没有注解");
            }
            for (Annotation annotation : paramAnnotation) {
                processMethodParamAnnotation(annotation);
            }
        }
    }

    public Request buildRequest(Object[] args) throws UnsupportedEncodingException {
        String url=mNiceClient.getUrl()+mPathUrl;
        mBuilder.url(url).addHeader(mHeader).addMethod(mHttpMethod);
        for (int i = 0; i < mAnnotationProcess.size(); i++) {
            mAnnotationProcess.get(i).process(args[i]);
        }
        return mBuilder.build();
    }

    private void processMethodParamAnnotation(Annotation annotation) {
        ParamAnnotationProcess process=null;
        if (annotation instanceof Field) {
            Field field=(Field)annotation;
            process=new FieldParamAnnotationProcess(mBuilder,field.value(),field.encoded());
        } else if (annotation instanceof FieldMap) {
            FieldMap fieldMap=(FieldMap)annotation;

        } else if (annotation instanceof Query) {
            Query query=(Query)annotation;
            process=new QueryParamAnnotationProcess(mBuilder,query.value(),query.encoded());
        } else if (annotation instanceof QueryMap) {
            QueryMap queryMap=(QueryMap)annotation;

        } else if (annotation instanceof Path) {
            Path path=(Path)annotation;

        } else if (annotation instanceof Body) {
            Body body=(Body)annotation;

        }
        mAnnotationProcess.add(process);
    }

    /**
     * 处理方法参数上的注解
     * @param annotation
     */
    private void processMethodAnnotation(Annotation annotation) {
        if (annotation instanceof POST) {
            POST post=(POST)annotation;
            mHttpMethod=HttpMethod.POST;
            mPathUrl=post.value();
        } else if (annotation instanceof GET) {

        } else if (annotation instanceof DELETE) {

        } else if (annotation instanceof PUT) {

        } else if (annotation instanceof Header) {

        } else if (annotation instanceof Retry) {

        }

    }
}
