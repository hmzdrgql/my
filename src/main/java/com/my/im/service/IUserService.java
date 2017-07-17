package com.my.im.service;

import java.util.List;

import com.my.im.model.User;

public interface IUserService {

	public User login(User user);
	
	public List<User> onlineUser();
	
	public Integer offTheLine(User user);
}
