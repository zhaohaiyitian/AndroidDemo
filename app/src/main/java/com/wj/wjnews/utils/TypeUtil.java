package com.wj.wjnews.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wj on 18-5-7.
 */

public class TypeUtil {

    public static Type getType(Class responseTYpe) {

        ParameterizedType parameterizedType;
        Type[] interfaceType = responseTYpe.getGenericInterfaces();
        if (interfaceType==null||interfaceType.length==0) {
            parameterizedType= (ParameterizedType) responseTYpe.getGenericSuperclass();
        } else {
            parameterizedType = (ParameterizedType) interfaceType[0];
        }
        Type[] paramType = parameterizedType.getActualTypeArguments();
        if (paramType==null||paramType.length==0) {
            throw new IllegalArgumentException("paramType is null");
        }
        return paramType[0];
    }
}
