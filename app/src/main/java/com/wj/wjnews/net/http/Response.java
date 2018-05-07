package com.wj.wjnews.net.http;

/**
 * 上层业务的Response
 * Created by wj on 18-5-7.
 */

public class Response<T> {

    private T mBody;
    private HttpResponse mResponse;

    public Response(T mBody, HttpResponse mResponse) {
        this.mBody = mBody;
        this.mResponse = mResponse;
    }

    public boolean isSuccess() {
        return mResponse.getStatus().isSuccess();
    }

    /**
     * 返回解析后的实体
     * @return
     */
    public T getBody() {
        return mBody;
    }
}
