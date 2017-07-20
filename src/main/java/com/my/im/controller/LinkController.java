package com.my.im.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
		user = userService.login(user);
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
	public String index(ModelMap modelMap) {
		
		List<User> list = userService.onlineUser();
		modelMap.put("list", list);
		
		return "im/index";
	}
	
	/**
	 * 跳转到首页
	 * @return
	 */
	@RequestMapping(value="/conversation/{id}",method=RequestMethod.GET)
	public String conversation(@PathVariable String id,ModelMap modelMap) {
		
		User toUser = userService.getById(id);
		modelMap.put("toUser", toUser);
		
		return "im/conversation";
	}
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public Map<String,Object> test(User user) {
		
		Map<String,Object> datas = new HashMap<String,Object>();
		
		List<User> list = userService.onlineUser();
		datas.put("list", list);
		System.out.println(list.size());
		return datas;
	}
	 
}
