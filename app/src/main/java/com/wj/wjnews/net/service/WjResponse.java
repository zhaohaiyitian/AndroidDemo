package com.wj.wjnews.net.service;

/**
 * @deprecated
 * Created by wj on 18-5-6.
 */

public abstract class WjResponse<T> {
    public abstract void success(WjRequest request,T data);
    public abstract void fail(int errorCode,String errorMsg);
}
