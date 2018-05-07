package com.wj.wjnews.net.service;

import com.wj.wjnews.net.http.HttpRequest;
import com.wj.wjnews.net.http.HttpResponse;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @deprecated
 * Created by wj on 18-5-6.
 */

public class HttpRunnable implements Runnable {
    private HttpRequest mHttpRequest;
    private WjRequest mRequest;
    private WorkStation mWorkStation;

    public HttpRunnable(HttpRequest mHttpRequest, WjRequest mRequest, WorkStation mWorkStation) {
        this.mHttpRequest = mHttpRequest;
        this.mRequest = mRequest;
        this.mWorkStation = mWorkStation;
    }

    @Override
    public void run() {
        try {
            mHttpRequest.getBody().write(mRequest.getData());
            HttpResponse response = mHttpRequest.execute();
            String contentType = response.getHeaders().getContentType();
            mRequest.setContentType(contentType);
            if (response.getStatus().isSuccess()) {
                if (mRequest.getResposne() != null) {
                    mRequest.getResposne().success(mRequest,new String(getData(response)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            mWorkStation.finish(mRequest);
        }
    }

    public byte[] getData(HttpResponse response) {
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream((int) response.getContentLength());
        int len=0;
        byte[] data=new byte[512];
        try {
            while ((len=response.getBody().read(data))!=-1) {
                outputStream.write(data,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
}
