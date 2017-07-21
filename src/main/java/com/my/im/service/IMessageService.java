package com.my.im.service;

import java.util.List;

import com.my.im.model.Message;

public interface IMessageService {

	/**
	 * 添加消息记录
	 * @return
	 */
	public Integer insert(Message message);
	
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
