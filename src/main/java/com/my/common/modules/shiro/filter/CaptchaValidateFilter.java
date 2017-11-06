package com.my.common.modules.shiro.filter;

import com.my.common.modules.shiro.constants.Constants;
import com.my.common.modules.sys.utils.ValidateCodeServlet;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by conan on 2017/5/26.
 */
public class CaptchaValidateFilter extends AccessControlFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest httpServletRequest = WebUtils.toHttp(servletRequest);
        return ValidateCodeServlet.validate(httpServletRequest, httpServletRequest.getParameter(ValidateCodeServlet.CAPTCHA));
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        if(servletRequest.getParameter(ValidateCodeServlet.CAPTCHA)!=null){
            servletRequest.setAttribute(Constants.ERROR_MESSAGE, Constants.CAPTCHA_ERROR);
        }
        return true;
    }
}
