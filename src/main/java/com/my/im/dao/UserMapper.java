package com.my.im.dao;

import java.util.List;

import com.my.common.base.BaseDao;
import com.my.common.bean.annotation.DataSource;
import com.my.im.model.User;

@DataSource
public interface UserMapper extends BaseDao<User> {

	public User login(User user);
	
	public List<User> onlineUser();
	
	public Integer offTheLine(User user);
}
