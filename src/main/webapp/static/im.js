        if (!window.WebSocket && window.MozWebSocket)
            window.WebSocket=window.MozWebSocket;
        if (!window.WebSocket)
            console.log("No Support");
        var ws;
        
        var path;
        
        var userId;
        var toUserId;
        var userPhoto;

        $(document).ready(function(){
        	
    		$("#sendTxtMsg").click(sendMessage);

            startWebSocket();
            
        })

        function sendMessage()
        {
        	userId = document.getElementById('userId').value;
            toUserId = document.getElementById('toUserId').value;
            userPhoto = document.getElementById('userPhoto').value;
        	var message = document.getElementById('message').value;  
            //var msg="发送消息";
            send("{\"content\":\""+message+"\",\"type\":\"RC:TxtMsg\",\"fromUser\":"+userId+",\"toUser\":"+toUserId+",\"userPhoto\":\""+userPhoto+"\"}");
        }
        function send(data)
        {
            console.log("Send:"+data);
            ws.send(data);
        }
        function startWebSocket()
        {    
        	path = document.getElementById('path').value;
        	
        	userId = document.getElementById('userId').value;
            /*ws = new WebSocket("ws://li.tunnel.qydev.com/my/im");*/
        	ws = new WebSocket("ws://li.tunnel.qydev.com/im?userId="+userId);
        	
        	var heartCheck = {
    		    timeout: 60000,//60ms
    		    timeoutObj: null,
    		    serverTimeoutObj: null,
    		    reset: function(){
    		        clearTimeout(this.timeoutObj);
    		        clearTimeout(this.serverTimeoutObj);
    		　　　　 this.start();
    		    },
    		    start: function(){
    		        var self = this;
    		        this.timeoutObj = setTimeout(function(){
    		            ws.send("{\"content\":\"HeartBeat\",\"type\":\"RC:CmdNtf\"}");
    		            self.serverTimeoutObj = setTimeout(function(){
    		                ws.close();//如果onclose会执行reconnect，我们执行ws.close()就行了.如果直接执行reconnect 会触发onclose导致重连两次
    		            }, self.timeout)
    		        }, this.timeout)
    		    },
        	};
        	
            ws.onopen = function(){
	        	console.log("发起连接请求");
	        	heartCheck.start();
            };
            ws.onmessage = function(event)
            {
                console.log("RECEIVE:"+event.data);
                //将消息插入页面
                /*$("#xiaoxi").append("<p>"+event.data+"</p>");*/
                var result = $.parseJSON(event.data);
                var html = "";
                if(result.type == "RC:TxtMsg"){
                	if(userId == result.fromUser){
                		console.log("我发送的");
                		
                		html +="<div class='talk_recordboxme'>"; 
                		html +="<div class='user'><img src='"+path+"/static/"+result.userPhoto+"'/></div>"; 
                		html +="<div class='talk_recordtextbg'>&nbsp;</div>";
                		html +="<div class='talk_recordtext'>";
                		html +="<h3>"+result.content+"</h3>";
                		html +="<span class='talk_time'>"+result.datetime+"</span>";
                		html +="</div></div>";
                		
                		$(".jspPane").append(html);
                	}else if(userId == result.toUser){
                		console.log("我接收的");
                		
                		html +="<div class='talk_recordbox'>"; 
                		html +="<div class='user'><img src='"+path+"/static/"+result.userPhoto+"'/></div>"; 
                		html +="<div class='talk_recordtextbg'>&nbsp;</div>";
                		html +="<div class='talk_recordtext'>";
                		html +="<h3>"+result.content+"</h3>";
                		html +="<span class='talk_time'>"+result.datetime+"</span>";
                		html +="</div></div>";
                		
                		$(".jspPane").append(html);
                	}
                	
                	$(".jspContainer").scrollTop($(".jspContainer")[0].scrollHeight);
                }
                
                heartCheck.reset();
            };
            ws.onclose = function(event) { 
            	console.log("Client notified socket has closed",event); 
            	startWebSocket();
            }; 
            ws.onerror = function () {
            	startWebSocket();
            };
        }