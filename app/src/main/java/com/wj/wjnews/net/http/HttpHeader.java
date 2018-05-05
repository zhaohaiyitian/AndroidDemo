package com.wj.wjnews.net.http;

import android.support.annotation.NonNull;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by wj on 18-5-5.
 */

public class HttpHeader implements NameValueMap<String,String> {

    public static final String ACCEPT = "Accept";
    public static final String PRAGMA = "Pragma";
    public static final String PROXY_CONNECTION = "Proxy-Connection";
    public static final String USER_AGENT = "User-Agent";
    public static final String ACCEPT_ENCODING = "accept-encoding";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_LENGTH = "Content-length";
    public static final String CONTENT_TYPE = "Content-Type";

    public String getAccept() {
        return get(ACCEPT);
    }

    public void setAccept(String value) {
        set(ACCEPT, value);
    }

    public String getPragma() {
        return get(PRAGMA);
    }

    public void setPragma(String value) {
        set(PRAGMA, value);
    }

    public String getUserAgent() {
        return get(USER_AGENT);
    }

    public void setUserAgent(String value) {
        set(USER_AGENT, value);
    }

    public String getProxyConnection() {
        return get(PROXY_CONNECTION);
    }

    public void setProxyConnection(String value) {
        set(PROXY_CONNECTION, value);
    }

    public String getAcceptEncoding() {
        return get(ACCEPT_ENCODING);
    }

    public void setAcceptEncoding(String value) {
        set(ACCEPT_ENCODING, value);
    }

    public String getCacheControl() {
        return get(CACHE_CONTROL);
    }

    public void setCacheControl(String value) {
        set(CACHE_CONTROL, value);
    }

    public String getContentEncoding() {
        return get(CONTENT_ENCODING);
    }

    public void setContentEncoding(String value) {
        set(CONTENT_ENCODING, value);
    }

    public String getConnection() {
        return get(CONNECTION);
    }

    public void setConnection(String value) {
        set(CONNECTION, value);
    }

    public String getContentLength() {
        return get(CONTENT_LENGTH);
    }

    public void setContentLength(String value) {
        set(CONTENT_LENGTH, value);
    }

    public String getContentType() {
        return get(CONTENT_TYPE);
    }

    public void setContentType(String value) {
        set(CONTENT_TYPE, value);
    }

    private Map<String,String> mMap=new HashMap<>();
    @Override
    public String get(String key) {
        return mMap.get(key);
    }

    @Override
    public void set(String key, String value) {
        mMap.put(key,value);
    }

    @Override
    public void setAll(Map<String, String> map) {
        mMap.putAll(map);
    }


    @Override
    public int size() {
        return mMap.size();
    }

    @Override
    public boolean isEmpty() {
        return mMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return mMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return containsValue(value);
    }

    @Override
    public String get(Object key) {
        return mMap.get(key);
    }

    @Override
    public String put(String key, String value) {
        return mMap.put(key,value);
    }

    @Override
    public String remove(Object key) {
        return mMap.remove(key);
    }

    @Override
    public void putAll(@NonNull Map<? extends String, ? extends String> m) {
        mMap.putAll(m);

    }

    @Override
    public void clear() {
        mMap.clear();

    }

    @NonNull
    @Override
    public Set<String> keySet() {
        return mMap.keySet();
    }

    @NonNull
    @Override
    public Collection<String> values() {
        return mMap.values();
    }

    @NonNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return mMap.entrySet();
    }
}
