package com.my.im.ws;

import java.io.IOException;

import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;

import com.my.common.utils.DateUtils;
import com.my.im.model.Message;
import com.my.im.service.IUserService;
import com.my.im.service.impl.MessageServiceImpl;
import com.my.im.websession.MySessionContext;

import net.sf.json.JSONObject;

@ServerEndpoint("/im")
public class EchoEndpoint {
	
	private MySessionContext myc=MySessionContext.getInstance();
	
	@Autowired
	private IUserService userService;
   
	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("session "+session.getId()+" open.");  
		
//        System.out.println("pathParams:"+session.getPathParameters());  
        System.out.println("requestParams"+session.getRequestParameterMap()); 
        
//		User user = MemberUtil.getCurrentUser();
//		user.setState(1);
//		userService.offTheLine(user);
        String userId = session.getRequestParameterMap().get("userId").get(0);
        
        if(session!=null)    
        {    
        	myc.AddSession(userId,session);
        }  
	}
	
	 
	@OnMessage
	public void onMessage(Session session, String message) {
		
		System.out.println(message);
		
		message = message.substring(0,message.length()-1)+",\"datetime\":\""+DateUtils.getCurrentTime()+"\"}";
		
		JSONObject json = JSONObject.fromObject(message);
		try {
			if(json.getString("type").equals("RC:TxtMsg")){
				System.out.println(json.getInt("fromUser"));
				System.out.println(json.getInt("toUser"));
				session.getBasicRemote().sendText(message);
				Session toUserSession = myc.getSession(json.getString("toUser"));
				//保存消息
				Message m=(Message)JSONObject.toBean(json, Message.class);
				if(toUserSession != null){
					System.out.println("发送的用户在线");
					toUserSession.getBasicRemote().sendText(message);
					m.setOffLine(1);
				}else{
					m.setOffLine(0);
				}
				MessageServiceImpl messageService = (MessageServiceImpl) ContextLoader.getCurrentWebApplicationContext().getBean("messageService");
				messageService.insert(m);
			}
			if(json.getString("type").equals("RC:CmdNtf")){
					session.getBasicRemote().sendText(message);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		for (Map.Entry<String, Session> entry : mymap.entrySet()) {
//			System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
//		    try {  
//		    	entry.getValue().getBasicRemote().sendText(message);  
//		    } catch (IOException e) {  
//		    	e.printStackTrace();  
//		    }  
//		}
	}
	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("session "+session.getId()+" error:"+throwable); 
		
		String userId = session.getRequestParameterMap().get("userId").get(0);
		
        if(session!=null)    
        {    
        	myc.DelSession(userId,session);
        }    
	}
	 
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println("session "+session.getId()+" close.");  
		
		System.out.println("requestParams"+session.getRequestParameterMap()); 
		
		String userId = session.getRequestParameterMap().get("userId").get(0);
		 
        if(session!=null)    
        {    
        	myc.DelSession(userId,session);
        }    
//		User user = MemberUtil.getCurrentUser();
//		user.setState(0);
//		userService.offTheLine(user);
	} 
	
}
