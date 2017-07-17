package com.my.common.modules.cache.bean;

/**
 * Created by conan on 2017/5/24.
 */
public class CacheBean {
    private String jsonValue;
    private Class defaultType;

    public String getJsonValue() {
        return jsonValue;
    }

    public void setJsonValue(String jsonValue) {
        this.jsonValue = jsonValue;
    }

    public Class getDefaultType() {
        return defaultType;
    }

    public void setDefaultType(Class defaultType) {
        this.defaultType = defaultType;
    }
}
