package com.my.common.modules.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.UUID;

/**
 * Created by conan on 2017/5/26.
 */
public class IdGen implements SessionIdGenerator{
    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @Override
    public Serializable generateId(Session session) {
        return IdGen.uuid();
    }
}
