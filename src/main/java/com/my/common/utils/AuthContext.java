package com.my.common.utils;

import com.my.common.bean.AuthEntity;

/**
 * Created by conan on 2017/5/24.
 */
public class AuthContext {
    private static ThreadLocal<AuthEntity> authEntityThreadLocal = new ThreadLocal<AuthEntity>();

    //获得当前请求者的权限标识
    public static AuthEntity getCurAuth() {
        AuthEntity authEntity = authEntityThreadLocal.get();
        return authEntity == null ? new AuthEntity() : authEntity;
    }

    //设置当前请求者的权限标识
    public static void setCurAuth(AuthEntity authEntity) {
        authEntityThreadLocal.set(authEntity);
    }

    //删除当前请求者的权限标识
    public static void removeCurAuth() {
        authEntityThreadLocal.remove();
    }
}
