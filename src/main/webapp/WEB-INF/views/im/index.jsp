<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>

<body>
	<div>
		<c:forEach var="friend" items="${list }">
			<a href="${ctx }/link/conversation/${friend.id}"><span class="notice_span">${friend.realName }</span></a>
		</c:forEach>
	</div>
	
	<script type="text/javascript">
	
	</script>
</body>
</html>