package com.my.im.websession;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;

public class MySessionContext {

	//静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
	@SuppressWarnings("unused")
	private static int onlineCount;
	private static MySessionContext instance;    
    private Map<String,Session> mymap;    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private MySessionContext()    
    {    
        mymap = new HashMap();    
    }    
    public static MySessionContext getInstance()    
    {    
        if(instance==null)    
        {    
            instance = new MySessionContext();    
        }    
        return instance;    
    }    
    public synchronized void AddSession(String id,Session session)    
    {    
        if(session!=null)    
        {    
        	onlineCount+=1;
//            mymap.put(session.getId(), session); 
        	mymap.put(id, session);  
        }    
    }    
    public synchronized void DelSession(String id,Session session)    
    {    
        if(session!=null)    
        {    
            mymap.remove(id); 
            onlineCount-=1;
        }    
    }    
    public synchronized Session getSession(String id)    
    {    
        if(id==null)return null;    
        return (Session)mymap.get(id);    
    }
	public Map<String, Session> getMymap() {
		return mymap;
	}
    
}
