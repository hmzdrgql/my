package com.my.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.im.dao.UserMapper;
import com.my.im.model.User;
import com.my.im.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService{

	@Autowired
    private UserMapper userMapper;
    
	public User login(User user) {
		return userMapper.login(user);
	}

	public List<User> onlineUser() {
		return userMapper.onlineUser();
	}

	public Integer offTheLine(User user) {
		return userMapper.offTheLine(user);
	}

	@Override
	public User getById(String id) {
		return userMapper.getById(id);
	}

}
