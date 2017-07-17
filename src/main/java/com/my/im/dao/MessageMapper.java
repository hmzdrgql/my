package com.my.im.dao;

import java.util.List;

import com.my.common.base.BaseDao;
import com.my.common.bean.annotation.DataSource;
import com.my.im.model.Message;

@DataSource
public interface MessageMapper extends BaseDao<Message>{

	/**
	 * 撤回消息
	 * @return
	 */
	public Integer delete(Message message);
	
	/**
	 * 获取消息记录（好友）
	 * @return
	 */
	public List<Message> getFriendMessages();
	
	/**
	 * 获取消息记录（群组）
	 * @return
	 */
	public List<Message> getGroupMessages();
}
