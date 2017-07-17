<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/jslib.jsp"%>
<title>首页</title>
</head>
<body>
	<div id="test">
		<textarea id="message" style="width: 350px">Here is a message!</textarea>
		<button id="sendTxtMsg">测试</button>
	</div>
	<div id="xiaoxi"></div>  
	<div id="zaixian"></div> 
	
	<input id="path" value="${ctx}"/>
	
	<script type="text/javascript">
	$(function(){
		var path = $("#path").val();
        $.ajax({
            type: "POST",
            url: path+"/user/getUserList",
            data: {},
            dataType: "json",
            success: function(data){
            	$('#zaixian').empty();   //清空resText里面的所有内容
                var html = ''; 
                $.each(data, function(commentIndex, comment){
	                 html += '<div class="comment"><h6>' + comment['username']
	                           + ':</h6><p class="para"' + comment['content']
	                           + '</p></div>';
                });
                $('#zaixian').html(html);
            }
		});
	});
	</script>
</body>
</html>