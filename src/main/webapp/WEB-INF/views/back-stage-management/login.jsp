<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理系统</title>
</head>
<body
<div class="login">
	<form method="post" id="form" action="${ctx}/login" role="form" >
		<div class="login_form">
			<div class="user">
                <div class="user_box"><label>用户名：</label><input class="text_value" name="username" type="text" placeholder="用户名"></div>
				<div class="user_box"><label>密&nbsp;&nbsp;&nbsp;码：</label><input class="text_value" name="password" type="password" placeholder="密码"></div>
                <button class="button" id="submit" type="submit">登 录</button>
			</div>
		</div>
	</form>
</div>
</body>
</html>


