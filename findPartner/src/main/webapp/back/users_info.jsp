<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ page import="com.yc.servlet.entity.*"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${deployName }">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
</head>
<body>
	<table id="dg"></table>
	<div id="usersDetail">
		<form action="#" method="post">
			<p>
				<label> 编号 </label> <input id="aid"/>
			</p>
			<p>
				<label> 昵称 </label> <input id="nickname"/>
			</p>
			<p>
				<label> 邮箱 </label> <input id="email"/>
			</p>
			<p>
				<label> 头像 </label>
				<img src="" style="width:100px;height:100px" id="picture">
			</p>
			<p>
				<label> 注册时间 </label><input id="regdate"/>
			</p>
			<input type="submit" value="提交"/> <input type="reset" value="重置"/>
		</form>
	</div>
	<script type="text/javascript" src="rel/js/users_info.js"></script>
</body>
</html>