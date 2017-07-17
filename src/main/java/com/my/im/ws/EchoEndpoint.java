package com.my.im.ws;

import java.io.IOException;

import javax.annotation.Resource;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.my.common.utils.MemberUtil;
import com.my.im.model.User;
import com.my.im.service.IUserService;
import com.my.im.websession.MySessionContext;

@ServerEndpoint("/im")
public class EchoEndpoint {
	
	private MySessionContext myc=MySessionContext.getInstance();
	
	@Resource
	private IUserService userService;
   
	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("session "+session.getId()+" open.");  
		
        //System.out.println("pathParams:"+session.getPathParameters());  
        //System.out.println("requestParams"+session.getRequestParameterMap()); 
        
//		User user = MemberUtil.getCurrentUser();
//		user.setState(1);
//		userService.offTheLine(user);
		
        if(session!=null)    
        {    
        	myc.AddSession(session);
        }  
	}
	
	 
	@OnMessage
	public void onMessage(Session session, String message) {
		
		System.out.println(message);
		
		
	
	  
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
        if(session!=null)    
        {    
        	myc.DelSession(session);
        }    
	}
	 
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println("session "+session.getId()+" close.");  
        if(session!=null)    
        {    
        	myc.DelSession(session);
        }    
//		User user = MemberUtil.getCurrentUser();
//		user.setState(0);
//		userService.offTheLine(user);
	} 
	
}
