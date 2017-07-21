package com.my.im.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.im.dao.MessageMapper;
import com.my.im.model.Message;
import com.my.im.service.IMessageService;

@Service("messageService")
public class MessageServiceImpl implements IMessageService{

	@Autowired
    private MessageMapper messageMapper;
    
	@Override
	public Integer insert(Message message) {
		return messageMapper.insert(message);
	}

	@Override
	public Integer delete(Message message) {
		return null;
	}

	@Override
	public List<Message> getFriendMessages() {
		return null;
	}

	@Override
	public List<Message> getGroupMessages() {
		return null;
	}

}
