package com.my.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.my.common.bean.AuthEntity;
import com.my.common.bean.annotation.LoginAnnot;
import com.my.common.modules.cache.CacheFacade;
import com.my.common.modules.sys.service.TokenService;
import com.my.common.utils.AuthContext;
import com.my.modules.wap.index.bean.LoginHeaderBean;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * Created by conan on 2017/5/24.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            AuthEntity curAuth = AuthContext.getCurAuth();
            //获取header中的相应验证信息
            String terminal = curAuth.getTerminal();
            String tokenStr = curAuth.getToken();
            String userId = curAuth.getUserId();
            //获取token后缀
            String suffix = TokenService.getSuffix(terminal);
            //验证请求头中的用户id和token是否匹配
            boolean success = this.checkToken(suffix, userId, tokenStr);
            //重置请求头中的token，保证真实有效
            if (!success&&!request.getRequestURI().startsWith("/wap")) {
                curAuth.setUserId(null);
                curAuth.setToken(null);
                AuthContext.setCurAuth(curAuth);
            }
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            LoginAnnot annotation = method.getAnnotation(LoginAnnot.class);
            //如果请求的接口需要验证token
            if (annotation != null) {
                if(request.getRequestURI().startsWith("/wap")){
                    try {
                        //如果有一项为空，返回没有权限
                        Cookie[] cookies = request.getCookies();
                        Cookie cookie = null;
                        for(int i = 0;i<cookies.length;i++){
                            if(cookies[i].getName().equals("login_header")){
                                cookie = cookies[i];
                                break;
                            }
                        }
                        if(cookie == null&&(StringUtils.isEmpty(terminal) || StringUtils.isEmpty(userId) || StringUtils.isEmpty(tokenStr))){
                            logger.info("cookie为空并且auth为空");
                            response.sendRedirect("/wap/registerPage");
                            return false;
                        } else if(cookie != null&&(StringUtils.isEmpty(terminal) || StringUtils.isEmpty(userId) || StringUtils.isEmpty(tokenStr)) ){
                            LoginHeaderBean loginHeaderBean = JSON.parseObject(URLDecoder.decode(cookie.getValue(),"utf-8"),LoginHeaderBean.class);
                            if (loginHeaderBean == null ||StringUtils.isEmpty(loginHeaderBean.getTerminal()) || StringUtils.isEmpty(loginHeaderBean.getUserId()) || StringUtils.isEmpty(loginHeaderBean.getToken())) {
                                logger.info("cookie不为空但是少字段");
                                response.sendRedirect("/wap/registerPage");
                                return false;
                            }
                        }
                    }catch (Exception e){
                        logger.info("解析出错");
                        response.sendRedirect("/wap/registerPage");
                        return false;
                    }
                }else {
                    if (StringUtils.isEmpty(terminal) || StringUtils.isEmpty(userId) || StringUtils.isEmpty(tokenStr)) {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        return false;
                    }
                    //如果上面验证的结果为错误
                    if (!success) {
                        //处理验证结果，返回没有权限
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 验证token
     *
     * @param suffix
     * @param userId
     * @param token
     * @return
     */
    private boolean checkToken(String suffix, String userId, String token) {
        String cachedToken = CacheFacade.getObject(userId + suffix);
        if (null == cachedToken) {
            return false;
        }
        return cachedToken.equals(token);
    }
}
