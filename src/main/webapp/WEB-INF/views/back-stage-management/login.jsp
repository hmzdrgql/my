<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title>后台管理系统</title>
	<style>
		* {
			margin:0;
			padding:0;
		}
		.slideshow {
			position: absolute;
			width: 100vw;
			height: 100vh;
			overflow: hidden;
		}
		.slideshow-image {
			position: absolute;
			width: 100%;
			height: 100%;
			background: no-repeat 50% 50%;
			background-size: cover;
			-webkit-animation-name: kenburns;
					animation-name: kenburns;
			-webkit-animation-timing-function: linear;
					animation-timing-function: linear;
			-webkit-animation-iteration-count: infinite;
					animation-iteration-count: infinite;
			-webkit-animation-duration: 20s;
					animation-duration: 20s;
			opacity: 1;
		}
		.slideshow-image:nth-child(1) {
			-webkit-animation-name: kenburns-1;
					animation-name: kenburns-1;
			z-index: 5;
		}
		.slideshow-image:nth-child(2) {
			-webkit-animation-name: kenburns-2;
			animation-name: kenburns-2;
			z-index: 4;
		}
		.slideshow-image:nth-child(3) {
			-webkit-animation-name: kenburns-3;
			animation-name: kenburns-3;
			z-index: 3;
		}
		.slideshow-image:nth-child(4) {
			-webkit-animation-name: kenburns-4;
			animation-name: kenburns-4;
			z-index: 2;
		}
		.slideshow-image:nth-child(5) {
			-webkit-animation-name: kenburns-5;
			animation-name: kenburns-5;
			z-index: 1;
		}
		@-webkit-keyframes kenburns-1 {
			0% {
				opacity: 1;
				-webkit-transform: scale(1.2);
						transform: scale(1.2);
			}
			20.0001% {
				opacity: 1;
			}
			23.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			98.4375% {
				opacity: 0;
				-webkit-transform: scale(1.21176);
				transform: scale(1.21176);
			}
			100% {
				opacity: 1;
			}
		}
		@keyframes kenburns-1 {
			0% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			20.0001% {
				opacity: 1;
			}
			23.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			98.4375% {
				opacity: 0;
				-webkit-transform: scale(1.21176);
				transform: scale(1.21176);
			}
			100% {
				opacity: 1;
			}
		}
		@-webkit-keyframes kenburns-2 {
			20.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			40.0001% {
				opacity: 1;
			}
			43.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
		}
		@keyframes kenburns-2 {
			20.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			40.0001% {
				opacity: 1;
			}
			43.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
		}
		@-webkit-keyframes kenburns-3 {
			40.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			60.0001% {
				opacity: 1;
			}
			63.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
		}
		@keyframes kenburns-3 {
			40.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			60.0001% {
				opacity: 1;
			}
			63.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
		}
		@-webkit-keyframes kenburns-4 {
			60.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			80.0001% {
				opacity: 1;
			}
			83.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
		}
		@keyframes kenburns-4 {
			60.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			80.0001% {
				opacity: 1;
			}
			83.1% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
		}
		@-webkit-keyframes kenburns-5 {
			80.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			99.9% {
				opacity: 1;
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
		}
		@keyframes kenburns-5 {
			80.0001% {
				opacity: 1;
				-webkit-transform: scale(1.2);
				transform: scale(1.2);
			}
			99.9% {
				opacity: 1;
			}
			100% {
				opacity: 0;
				-webkit-transform: scale(1);
				transform: scale(1);
			}
		}
		.login {
			z-index: 999;
			position: absolute;
			top: 20vh;
			width: 100%;
			text-align: center;
		}
		.login form {
			background-color: rgba(7, 10, 10, 0.52);
			height: 400px;
			width: 400px;
			border-radius: 300px;
			margin: 0 auto;
		}
		.login form .username,.login form .password {
			position: relative;
			top: 40px;
			border: solid 2px rgba(255, 255, 255, 0.72);
			border-radius: 35px;
			margin: 10px auto;
			text-align: left;
			height: 30px;
			width: 200px;
		}
		.login form .input-1,.login form .input-2 {
			padding: 0;
			background: rgba(0,0,0,0);
			border: hidden;
			outline:none;
			height: 30px;
			width: 140px;
			position: relative;
			color: #FFF;
			left: 30px;
			font-size: 20px;
		}
	</style>
</head>
<body>

	<div class="slideshow">
		<div class="slideshow-image" style="background-image: url('../../../static/images/background/back1.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('../../../static/images/background/back2.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('../../../static/images/background/back3.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('../../../static/images/background/back4.jpg')"></div>
		<div class="slideshow-image" style="background-image: url('../../../static/images/background/back5.jpg')"></div>
	</div>

	<div class="login">
		<form id="login-form" action="${ctx}/login" method="post">
			<div class="username">
				<input type="text" name="userName" class="input-1" placeholder="请输入账号"/>
			</div>
			<div class="password">
				<input type="text" name="passWord" class="input-2" placeholder="请输入密码"/>
			</div>
			<div class="">
				<input type="button" value="登录" class="login-btn"/>
			</div>
		</form>
	</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script>

</script>

</body>
</html>


