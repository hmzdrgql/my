package com.my.common.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.my.im.model.User;

public class MemberUtil {

	/**
	 * 获取当前用户
	 * @return
	 */
	public static User getCurrentUser(){
		HttpServletRequest  request =  ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return (User)request.getSession().getAttribute("user");
	}
	
	/**
	 * 获取当前用户id
	 * @return
	 */
	public static int getUid(){
		User user = getCurrentUser();
		if(user != null){
			return user.getId();
		}
		return 0;
	}
	
}
