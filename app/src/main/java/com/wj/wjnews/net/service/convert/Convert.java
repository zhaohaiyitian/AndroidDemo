package com.wj.wjnews.net.service.convert;

import com.wj.wjnews.net.http.HttpResponse;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * Created by wj on 18-5-6.
 */

public interface Convert {
    Object parse(HttpResponse response, Type type) throws IOException;
    boolean isCanParse(String contentType);
    Object parse(String content,Type type);
}
