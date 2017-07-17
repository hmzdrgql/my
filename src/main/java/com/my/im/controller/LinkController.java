package com.my.im.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.my.im.model.User;
import com.my.im.service.IUserService;

@Controller
@RequestMapping("/link")
public class LinkController {
	
	@Autowired
	private IUserService userService;

	/**
	 * 跳转到登录
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	 
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request) {
		System.out.println(user);
		user = userService.login(user);
		System.out.println(user);
		if(user != null){
			request.getSession().setAttribute("user", user);
		}
		return "redirect:/link/index";
	}
	 
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index() {
		return "index";
	}
	 
}
