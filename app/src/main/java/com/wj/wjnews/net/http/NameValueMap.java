package com.wj.wjnews.net.http;


import java.util.Map;

/**
 * Created by wj on 18-5-5.
 */

public interface NameValueMap<K,V> extends Map<K,V> {
    String get(String key);
    void set(String key,String value);
    void setAll(Map<String,String> map);
}
