<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<%@ include file="../../common/csslib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
	<style type="text/css">
		.container {
			overflow: hidden;
			position: fixed;
			top: 0;
			left: 0;
			height: 100%;
			width: 100%;
			background: url("../../../static/images/background/im-login.jpg");
			text-align: center;
		}
		.container .login-container {
			margin: auto;
			position: relative;
			top: 30%;
			height: 400px;
			width: 400px;
		}
		.container .login-container form {
			height: 400px;
			width: 400px;
			background: rgba(0,0,0,0);
		}
		.container .login-container form div{
			height: 50px;
			width: 300px;
			border: solid 2px rgba(255, 255, 255, 0.72);
			border-radius: 35px;
			margin: 10px auto;
			text-align: left;
		}
		.container .login-container form .input-1,.container .login-container form .input-2 {
			padding: 0;
			background: rgba(0,0,0,0);
			border: hidden;
			outline:none;
			height: 32px;
			width: 200px;
			position: relative;
			top: 2px;
			left: 20px;
			color: #FFF;
			font-size: 20px;
		}
		::-webkit-input-placeholder { /* WebKit browsers */
			color: rgba(254, 255, 249, 0.73);
		}
		:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
			color: rgba(254, 255, 249, 0.73);
		}
		::-moz-placeholder { /* Mozilla Firefox 19+ */
			color: rgba(254, 255, 249, 0.73);
		}
		:-ms-input-placeholder { /* Internet Explorer 10+ */
			color: rgba(254, 255, 249, 0.73);
		}
		i:before {
			color: rgba(255, 255, 255, 0.66);
		}
		.input-group-addon {
			position: relative;
			height: 32px;
			top: 9px;
			left: 15px;
		}
		.login-btn {
			color: #FFF;
			background-color: #00c6ff;
			height: 50px;
			width: 300px;
			border-radius: 35px;
			outline: none;
			border: hidden;
			font-size: 20px;
		}
	</style>
</head>
<body>
	<div class="container">
		<div class="login-container">
			<form action="${ctx}/im/link/login" method="post" id="login-form">
				<div class="username">
					<span class="input-group-addon"><i class="fa fa-user fa-fw fa-2x"></i></span>
					<input type="text" name="userName" class="input-1" placeholder="请输入账号"/>
				</div>
				<div class="password">
					<span class="input-group-addon"><i class="fa fa-key fa-fw fa-2x"></i></span>
					<input type="text" name="passWord" class="input-2" placeholder="请输入密码"/>
				</div>
				<div class="password">
					<input type="button" value="登录" class="login-btn"/>
				</div>
				<%--<input type="submit" value="Submit"/>--%>
			</form>
		</div>
	</div>

<script src="${ctx}/static/js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script type="text/javascript">
	$(".login-btn").click(function(){
		$("#login-form").submit();
	});
</script>
</body>
</html>