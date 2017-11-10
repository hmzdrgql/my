package com.my.im.ws;

import com.my.im.websession.MySessionContext;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

@ServerEndpoint("/im/live")
public class BroadcastEndpoint {
	
	private MySessionContext myc=MySessionContext.getInstance();
	
	@OnOpen
	public void onOpen(Session session) throws IOException {
		System.out.println("session "+session.getId()+" open.");
		
//        System.out.println("pathParams:"+session.getPathParameters());  
        System.out.println("requestParams"+session.getRequestParameterMap()); 
        
	}
	
	 
	@OnMessage
	public void onMessage(Session session, Reader ir) {
		System.out.println("传输视频中");
		BufferedReader br=new BufferedReader(ir);
		StringBuilder sb=new StringBuilder();
		String temp=null;
		try {
			while((temp=br.readLine())!=null){
                sb.append(temp);
				System.out.println(temp);
				session.getBasicRemote().sendText(temp);
            }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@OnError
	public void onError(Session session, Throwable throwable) {
		System.err.println("session "+session.getId()+" error:"+throwable); 
	}
	 
	@OnClose
	public void onClose(Session session, CloseReason reason) {
		System.out.println("session "+session.getId()+" close.");  
		
		System.out.println("requestParams"+session.getRequestParameterMap()); 
	}
	
}
