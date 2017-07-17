        if (!window.WebSocket && window.MozWebSocket)
            window.WebSocket=window.MozWebSocket;
        if (!window.WebSocket)
            console.log("No Support");
        var ws;

        $(document).ready(function(){
            
    		$("#sendTxtMsg").click(sendMessage);

            startWebSocket();
        })

        function sendMessage()
        {
        	var message = document.getElementById('message').value;  
            //var msg="发送消息";
            send("{message:"+message+",type:RC:TxtMsg,fromUser:,toUser}");
        }
        function send(data)
        {
            console.log("Send:"+data);
            ws.send(data);
        }
        function startWebSocket()
        {    
            ws = new WebSocket("ws://li.tunnel.qydev.com/my/im");
            ws.onopen = function(){
	        	console.log("发起连接请求");
            };
            ws.onmessage = function(event)
            {
                console.log("RECEIVE:"+event.data);
                //将消息插入页面
                $("#xiaoxi").append("<p>"+event.data+"</p>");
            };
            ws.onclose = function(event) { 
            console.log("Client notified socket has closed",event); 
            }; 
          
        }