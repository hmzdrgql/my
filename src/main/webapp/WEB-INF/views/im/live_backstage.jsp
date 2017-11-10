<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ include file="../../common/jslib.jsp"%>
    <title>直播后台</title>
</head>
<body>

<div class="container">
  <%--  <h3>Current filter is: None</h3>
    <button>Click here to change video filter</button>
    <div style="clear:both"></div>
    <div class="col">
        <h2>HTML5 object</h2>
        <video></video>
    </div>--%>
    <%--<div class="col">
        <h2>HTML5 object</h2>
        <canvas width="600" height="450"></canvas>
    </div>--%>

    <input type="submit" value="clientLogin" onclick="start()">
    <div id="messages">
    </div>
    <video id="remoteVideo" autoplay></video>
    <video id="localVideo" autoplay></video>
</div>


<%--<script type="text/javascript">
    // Main initialization
    document.addEventListener('DOMContentLoaded', function() {
        // Global variables
        var video = document.querySelector('video');
        var audio, audioType;
        /*var canvas = document.querySelector('canvas');
        var context = canvas.getContext('2d');*/
        // Custom video filters
        var iFilter = 0;
        var filters = [
            'grayscale',
            'sepia',
            'blur',
            'brightness',
            'contrast',
            'hue-rotate',
            'hue-rotate2',
            'hue-rotate3',
            'saturate',
            'invert',
            'none'
        ];
        // Get the video stream from the camera with getUserMedia
        navigator.getUserMedia = navigator.getUserMedia || navigator.webkitGetUserMedia ||
                navigator.mozGetUserMedia || navigator.msGetUserMedia;
        window.URL = window.URL || window.webkitURL || window.mozURL || window.msURL;
        if (navigator.getUserMedia) {
            // Evoke getUserMedia function
            navigator.getUserMedia({video: true, audio: true}, onSuccessCallback, onErrorCallback);
            function onSuccessCallback(stream) {
                // Use the stream from the camera as the source of the video element
                video.src = window.URL.createObjectURL(stream) || stream;
                // Autoplay
                video.play();
                // HTML5 Audio
                audio = new Audio();
                audioType = getAudioType(audio);
                if (audioType) {
                    audio.src = 'polaroid.' + audioType;
                    audio.play();
                }
            }
            // Display an error
            function onErrorCallback(e) {
                var expl = 'An error occurred: [Reason: ' + e.code + ']';
                console.error(expl);
                alert(expl);
                return;
            }
        } else {
            document.querySelector('.container').style.visibility = 'hidden';
            document.querySelector('.warning').style.visibility = 'visible';
            return;
        }
        // Draw the video stream at the canvas object
        function drawVideoAtCanvas(obj, context) {
            window.setInterval(function() {
                context.drawImage(obj, 0, 0);
            }, 60);
        }
        // The canPlayType() function doesn't return true or false. In recognition of how complex
        // formats are, the function returns a string: 'probably', 'maybe' or an empty string.
        function getAudioType(element) {
            if (element.canPlayType) {
                if (element.canPlayType('audio/mp4; codecs="mp4a.40.5"') !== '') {
                    return('aac');
                } else if (element.canPlayType('audio/ogg; codecs="vorbis"') !== '') {
                    return("ogg");
                }
            }
            return false;
        }
        // Add event listener for our video's Play function in order to produce video at the canvas
        video.addEventListener('play', function() {
            drawVideoAtCanvas(this, context);
        }, false);
        // Add event listener for our Button (to switch video filters)
        document.querySelector('button').addEventListener('click', function() {
            video.className = '';
            //canvas.className = '';
            var effect = filters[iFilter++ % filters.length]; // Loop through the filters.
            if (effect) {
                video.classList.add(effect);
                //canvas.classList.add(effect);
                document.querySelector('.container h3').innerHTML = 'Current filter is: ' + effect;
            }
        }, false);
    }, false);
</script>--%>

<script type="text/javascript">
    function onOpen(event) {
        document.getElementById('messages').innerHTML
                = 'Connection established';
    }

    function onError(event) {
        document.getElementById('messages').innerHTML
                += '<br/>'+event.data;
    }


    function start() {
        var webSocket =new WebSocket("wss://li.tunnel.qydev.com/im/live");
        webSocket.onopen = function(event) {
            onOpen(event);
        };
        webSocket.onerror = function(event) {
            onError(event);
        };
        webSocket.onclose=function(event){
            alert(event.data)
        };


        //处理到来的信令
        webSocket.onmessage = function(event){
            //alert(event.data);
            //document.getElementById('messages').innerHTML
            // += '<br/>'+event.data;
            var jsonstr="'"+event.data+"'";
            var json = JSON.parse(event.data);

            console.log('onmessage: ', json);

            document.getElementById('remoteVideo').src = URL.createObjectURL(json);
        };

        // 获取本地音频和视频流
        navigator.webkitGetUserMedia({
            "audio": true,
            "video": true
        }, function(stream){
            //绑定本地媒体流到video标签用于输出
            document.getElementById('localVideo').src = URL.createObjectURL(stream);
            webSocket.send(stream);
        }, function(error){
            //处理媒体流创建失败错误
            console.log('getUserMedia error: ' + error);
        })

    }


   /*function onOpen(event) {
       document.getElementById('messages').innerHTML
               = 'Connection established';
   }

   function onError(event) {
       document.getElementById('messages').innerHTML
               += '<br/>'+event.data;
   }
   function start() {
       var webSocket =new WebSocket("wss://li.tunnel.qydev.com/im/live");

       webSocket.onopen = function(event) {
           onOpen(event);
       };

       webSocket.onerror = function(event) {
           onError(event);
       };

       webSocket.onclose=function(event){
           //document.getElementById('messages').innerHTML
           //+= '<br/>'+str(event.data);
           alert(event.data);
       }
       // 创建PeerConnection实例 (参数为null则没有iceserver，即使没有stunserver和turnserver，仍可在局域网下通讯)
       var pc = new webkitRTCPeerConnection(null);

       // 发送ICE候选到其他客户端


       // 如果检测到媒体流连接到本地，将其绑定到一个video标签上输出
       pc.onaddstream = function(event){
           //alert("检测到流");
           document.getElementById('remoteVideo').src = webkitURL.createObjectURL(event.stream);
       };

       // 发送offer和answer的函数，发送本地session描述
       /!*var sendOfferFn = function(desc){

        alert(desc.sdp)
        //pc.setRemoteDescription(desc);
        // pc.setLocalDescription(desc);

        webSocket.send(JSON.stringify({
        "event": "_offer",
        "data": {
        "sdp": desc
        }
        }));
        };*!/

       pc.onicecandidate = function(event){
           if (event.candidate !== null) {
               webSocket.send(JSON.stringify({
                   "event": "_ice_candidate",
                   "data": {
                       "candidate": event.candidate
                   }
               }));
           }
       };
       var sendAnswerFn = function(desc){

           pc.setLocalDescription(desc);
           webSocket.send(JSON.stringify({
               "event": "_answer",
               "data": {
                   "sdp": desc
               }
           }));
       };

       // 获取本地音频和视频流
       navigator.webkitGetUserMedia({
        "audio": true,
        "video": true
        }, function(stream){
        //绑定本地媒体流到video标签用于输出
        document.getElementById('localVideo').src = URL.createObjectURL(stream);
        //向PeerConnection中加入需要发送的流
        pc.addStream(stream);
        //如果是发起方则发送一个offer信令

        }, function(error){
        //处理媒体流创建失败错误
        console.log('getUserMedia error: ' + error);
        });

       //处理到来的信令
       webSocket.onmessage = function(event){
           //alert(event.data)
           //document.getElementById('messages').innerHTML
           //+= '<br/>'+event.data;
           var jsonstr="'"+event.data+"'"
           var json = JSON.parse(event.data);
           console.log('onmessage: ', json);
           //如果是一个ICE的候选，则将其加入到PeerConnection中，否则设定对方的session描述为传递过来的描述

           if( json.event == "_ice_candidate" ){
               //alert("收到候选");
               pc.addIceCandidate(new RTCIceCandidate(json.data.candidate));

           } else {

               if(json.event == "_offer") {
                   pc.setRemoteDescription(new RTCSessionDescription(json.data.sdp),function(){
                       //pc.setRemoteDescription(null,function(){
                       pc.createAnswer(sendAnswerFn, function (error) {
                           alert(error);
                           console.log('Failure callback: ' + error);
                       });
                   },function(){
                       alert("error");
                       pc.createAnswer(sendAnswerFn, function (error) {
                           alert("error");
                           console.log('Failure callback: ' + error);
                       });
                   });

               }

               //  pc.setRemoteDescription(new RTCSessionDescription(json.data.sdp,function(){
               //  alert(1);
               //}));
               //  if (isRTCPeerConnection)
               //  pc.setRemoteDescription(new RTCSessionDescription(json.data.sdp));
               // else
               //   pc.setRemoteDescription(pc.SDP_OFFER,
               //        new SessionDescription(json.data.sdp.sdp));
               //pc.setRemoteDescription(new RTCSessionDescription(pc.SDP_OFFER,json.data.sdp));
               //pc.SDP_OFFER
               //pc.setRemoteDescription(pc.SDP_OFFER,new SessionDescription(json.data.sdp.sdp));
               // 如果是一个offer，那么需要回复一个answer
               /!* if(json.event == "_offer") {
                alert(json.event)
                pc.createAnswer(sendAnswerFn, function (error) {
                document.getElementById('messages').innerHTML
                += '<br/>'+error;
                console.log('Failure callback: ' + error);
                });
                }*!/
           }
       };
   }*/
</script>
</body>
</html>