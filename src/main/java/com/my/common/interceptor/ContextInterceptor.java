package com.my.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.my.common.bean.AuthEntity;
import com.my.common.bean.annotation.WeiXinLogin;
import com.my.common.utils.AuthContext;
import com.my.common.utils.ContextUtils;
import com.my.common.utils.Utils;
import com.my.modules.wap.index.service.ThirdLoginService;
import org.apache.log4j.Logger;
import com.my.common.constants.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by conan on 2017/5/24.
 */
public class ContextInterceptor extends HandlerInterceptorAdapter {
    private static Logger logger = Logger.getLogger(ContextInterceptor.class);
    @Autowired
    protected ThirdLoginService thirdLoginService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        ContextUtils.setReqRes(request, response);
        String authStr = request.getHeader(Constants.Http.AUTHORIZATION);
        if (authStr != null) {
            //设置当前请求者的权限标识
            try {
                AuthEntity authEntity = JSON.parseObject(authStr, AuthEntity.class);
                authEntity.setIp(Utils.getAddress(request));
                AuthContext.setCurAuth(authEntity);
            } catch (Exception e) {

            }
        } else {
            AuthEntity authEntity = new AuthEntity();
            authEntity.setIp(request.getRemoteAddr());
            AuthContext.setCurAuth(authEntity);
        }
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            WeiXinLogin weiXinLogin = method.getAnnotation(WeiXinLogin.class);
            if (weiXinLogin != null) {
                String code = request.getParameter("code");
                if (code != null && !"".equals(code)) {
                  /*  thirdLoginService.weiXinLogin(code);*/
                }
            }
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        ContextUtils.removeReqRes();
        //删除当前请求者的权限标识
        AuthContext.removeCurAuth();
    }
}
