package com.my.common.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by conan on 2017/5/24.
 */
public class ContextUtils {
    private static ThreadLocal<HttpServletRequest> httpServletRequestThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<HttpServletResponse> httpServletResponseThreadLocal = new ThreadLocal<>();

    public static HttpServletResponse getResponse() {
        return httpServletResponseThreadLocal.get();
    }

    public static HttpServletRequest getRequest() {
        return httpServletRequestThreadLocal.get();
    }

    public static void removeReqRes() {
        httpServletRequestThreadLocal.remove();
        httpServletResponseThreadLocal.remove();
    }


    public static void setReqRes(HttpServletRequest request, HttpServletResponse response) {
        httpServletRequestThreadLocal.set(request);
        httpServletResponseThreadLocal.set(response);
    }
}
