package com.my.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.my.common.bean.AuthEntity;
import com.my.common.bean.annotation.LoginAnnot;
import com.my.common.modules.cache.CacheFacade;
import com.my.common.modules.sys.service.TokenService;
import com.my.common.utils.AuthContext;
import com.my.common.utils.Utils;
import com.my.modules.wap.index.bean.LoginHeaderBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.Enumeration;

/**
 * Created by conan on 2017/5/24.
 */
public class LogInterceptor implements HandlerInterceptor{
    /**
     * 日志对象
     */
    protected org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String method = httpServletRequest.getMethod();
        StringBuffer params = new StringBuffer();
        Enumeration<?> temp = httpServletRequest.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = httpServletRequest.getParameter(en);
                if(StringUtils.isNotBlank(value)){
                    params.append("&").append(en).append("=").append(value);
                }
            }
        }
        if (params.length() > 0) {
            params = params.replace(0,1,"?");
        }
        logger.warn(new StringBuffer("访问者ip:")
                .append(Utils.getAddress(httpServletRequest))
                .append(":")
                .append(httpServletRequest.getRemotePort())
                .append("\n")
                .append(method)
                .append(": ")
                .append(httpServletRequest.getRequestURI())
                .append(params)
        );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
