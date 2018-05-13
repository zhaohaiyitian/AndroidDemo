package com.wj.wjnews.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by wj on 18-5-7.
 * 拿到当前所配置的泛型信息
 */

public class TypeUtil {

    public static Type getType(Class responseTYpe) {

        ParameterizedType parameterizedType;
        Type[] interfaceType = responseTYpe.getGenericInterfaces();
        if (interfaceType==null||interfaceType.length==0) {
            throw new IllegalArgumentException("responseTYpe is null");
        } else {
            parameterizedType = (ParameterizedType) interfaceType[0];
        }
        Type[] paramType = parameterizedType.getActualTypeArguments();//拿到真实的泛型类型
        if (paramType==null||paramType.length==0) {
            throw new IllegalArgumentException("paramType is null");
        }
        return paramType[0];
    }
}
