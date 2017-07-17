package com.my.common.modules.cache;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.my.common.constants.ProjectConstants;
import com.my.common.modules.cache.bean.CacheBean;
import com.my.common.modules.cache.impl.LocalCache;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by conan on 2017/5/24.
 */
public class CacheFacade {
    private final static Logger logger = Logger.getLogger(CacheFacade.class);
    // 缓存操作实例
    private static Cache cache;
    public static void shutdown() {
        cache.shutdown();
    }
    /**
     * 设置缓存
     *
     * @param key
     * @param value
     * @param exp   失效时间(秒)
     */
    public static void set(String key, Object value, int exp) {
        if (null == cache) {
            getCache();
        }
        CacheBean cacheBean = new CacheBean();
        cacheBean.setDefaultType(value.getClass());
        cacheBean.setJsonValue(JSON.toJSONString(value));
        cache.set(ProjectConstants.PROJECT_NAME + "_" + key, JSON.toJSONString(cacheBean), exp);
    }

    /**
     * 删除缓存数据
     *
     * @param key
     */
    public static void delete(String key) {
        if (null == cache) {
            getCache();
        }
        cache.delete(ProjectConstants.PROJECT_NAME + "_" + key);
    }

    /**
     * 从缓存获得对象
     *
     * @param key
     * @return
     */
    private static CacheBean getByCache(String key) {
        if (null == cache) {
            getCache();
        }
        Object value = cache.get(ProjectConstants.PROJECT_NAME + "_" + key);
        if (value == null) {
            return null;
        }
        return JSON.parseObject(value.toString(), CacheBean.class);
    }

    /**
     * 获取缓存对象,解析为默认的class对象
     *
     * @param key
     * @return
     */
    public static <T> T getObject(String key, TypeReference<T>... typeReference) {
        CacheBean cacheBean = getByCache(key);
        if (cacheBean == null) {
            return null;
        }
        if (typeReference != null && typeReference.length > 0) {
            return JSON.parseObject(cacheBean.getJsonValue(), typeReference[0]);
        }
        return (T) JSON.parseObject(cacheBean.getJsonValue(), cacheBean.getDefaultType());
    }

    /**
     * 获取缓存数据,如果关键字不存在返回null
     *
     * @param key
     * @return
     */
    public static <T> List<T> getList(String key, Class type) {
        CacheBean cacheBean = getByCache(key);
        if (cacheBean == null) {
            return null;
        }
        return JSON.parseArray(cacheBean.getJsonValue(), type);
    }

    private static void getCache() {
        // 本地缓存
        if (ProjectConstants.PRO_DEBUG) {
            cache = new LocalCache();
        }
    }
}
