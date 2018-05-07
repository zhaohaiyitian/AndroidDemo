package com.wj.wjnews.net.service;

import com.wj.wjnews.net.service.convert.Convert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @deprecated
 * Created by wj on 18-5-6.
 */

public class WrapperResponse extends WjResponse<String> {
    private WjResponse mWjResponse;
    private List<Convert> mConvert;

    public WrapperResponse(WjResponse mWjResponse, List<Convert> convert) {
        this.mWjResponse = mWjResponse;
        this.mConvert = convert;
    }

    @Override
    public void success(WjRequest request, String data) {
        for (Convert convert : mConvert) {
            if (convert.isCanParse(request.getContentType())) {
                Object object=convert.parse(data,getType());
                mWjResponse.success(request,object);
            }
            return;
        }
    }

    @Override
    public void fail(int errorCode, String errorMsg) {

    }

    public Type getType() {
        Type type = mWjResponse.getClass().getGenericSuperclass();
        Type[] types = ((ParameterizedType) type).getActualTypeArguments();
        return types[0];
    }
}
