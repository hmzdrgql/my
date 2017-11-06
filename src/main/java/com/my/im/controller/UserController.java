package com.my.im.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.im.service.IUserService;
import com.my.im.websession.MySessionContext;

@Controller
@RequestMapping("/user")
public class UserController {

	private MySessionContext myc=MySessionContext.getInstance(); 
	
	@Autowired
	private IUserService userService;
	
	/**
	 * 获取当前所有用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getUserList",method=RequestMethod.POST)
	public String getUserList(){
		Map<String,Session> map = myc.getMymap();
		return "";
	}

}
