package com.my.common.modules.retrofit.bean;

/**
 * Created by conan on 2017/5/24.
 */
public class HttpApiBean {
    private String baseUrl;
    private Class[] interceptors;
    private Class clazz;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Class[] getInterceptors() {
        return interceptors;
    }

    public void setInterceptors(Class[] interceptors) {
        this.interceptors = interceptors;
    }
}
