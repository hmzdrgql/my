package com.my.common.base;

import com.my.common.bean.ResponseErrorEntity;
import com.my.common.bean.ResultError;
import com.my.common.bean.StatusCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by conan on 2017/7/13.
 */
public abstract class BaseController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;
    /**
     * 日志对象
     */
    protected Logger logger = Logger.getLogger(getClass());

    /**
     * 获取请求参数中所有的信息
     *
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

    /**
     * 解析异常参数返回错误信息
     *
     * @param errors
     * @return
     */
    protected ResponseEntity parseErrors(Errors errors) {
        return new ResponseErrorEntity(new ResultError(StatusCode.VALIDATION_FAILED.getValue(), errors.getFieldError().getField() + ":" + errors.getFieldError().getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

}
