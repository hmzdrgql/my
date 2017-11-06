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

import com.my.im.model.Message;
import com.my.im.model.User;
import com.my.im.service.IMessageService;
import com.my.im.service.IUserService;

@Controller
@RequestMapping("/im/link")
public class LinkController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IMessageService messageService;

	/**
	 * 跳转到登录页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "im/login";
	}
	 
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request) {
		user = userService.login(user);
		if(user != null){
			request.getSession().setAttribute("user", user);
		}
		return "redirect:/im/link/index";
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
	public String conversation(@PathVariable String id,ModelMap modelMap,HttpServletRequest request) {
		
		User toUser = userService.getById(id);
		modelMap.put("toUser", toUser);
		
		//获取当前用户
		User fromUser = (User)request.getSession().getAttribute("user");
		//查询历史聊天记录
		Message message = new Message(fromUser.getId(),toUser.getId());
		List<Message> list = messageService.getFriendMessages(message);
		modelMap.put("list", list);
		
		return "im/conversation";
	}

	/**
	 * 直播后台
	 * @return
     */
	@RequestMapping(value="/toLiveBackstage",method=RequestMethod.GET)
	public String toLiveBackstage(){
		return "im/live_backstage";
	}
	
	@ResponseBody
	@RequestMapping(value="/test",method=RequestMethod.POST)
	public Map<String,Object> test(User user) {
		
		Map<String,Object> datas = new HashMap<String,Object>();
		
		List<User> list = userService.onlineUser();
		datas.put("list", list);
		return datas;
	}
	 
}
