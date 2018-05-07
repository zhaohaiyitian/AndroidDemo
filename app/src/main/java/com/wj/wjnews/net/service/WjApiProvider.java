package com.wj.wjnews.net.service;

import com.wj.wjnews.net.http.HttpMethod;
import com.wj.wjnews.net.service.convert.Convert;
import com.wj.wjnews.net.service.convert.JsonConvert;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @deprecated
 * Created by wj on 18-5-6.
 */

public class WjApiProvider {
    public static final String ENCODING="utf-8";
    private static WorkStation workStation=new WorkStation();

    private static List<Convert> sConverts=new ArrayList<>();

    static {
        sConverts.add(new JsonConvert());
    }
    public static byte[] encodeParam(Map<String,String> value) {
        if (value==null||value.size()==0) {
            return null;
        }
        StringBuffer buffer=new StringBuffer();
        int count=0;
        for (Map.Entry<String, String> entry : value.entrySet()) {
            try {
                buffer.append(URLEncoder.encode(entry.getKey(),ENCODING))
                      .append("=")
                      .append(URLEncoder.encode(entry.getValue(),ENCODING));
                if (count!=value.size()-1) {
                    buffer.append("&");
                }
                count++;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return buffer.toString().getBytes();

    }
    public static void hello(String url, Map<String,String> value,WjResponse<String> response) {
        WjRequest request=new WjRequest();
        WrapperResponse wrapperResponse=new WrapperResponse(response,sConverts);
        request.setUrl(url);
        request.setMethod(HttpMethod.GET);
        request.setData(encodeParam(value));
        request.setResposne(wrapperResponse);
        workStation.add(request);

    }
}
