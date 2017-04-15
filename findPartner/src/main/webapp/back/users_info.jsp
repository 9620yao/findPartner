<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%-- <%@ page import="com.yc.servlet.entity.*"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${deployName }">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<table id="dg"></table>
	<div id="usersDetail">
		<form action="#" method="post">
			<p>
				<label> 编号 </label> <input id="iaid"/>
			</p>
			<p>
				<label> 昵称 </label> <input id="inickname"/>
			</p>
			<p>
				<label> 性别 </label> <input id="igender"/>
			</p>
			<p>
				<label> 邮箱 </label> <input id="iemail"/>
			</p>
			<p>
				<label> 生日 </label> <input id="ibirthday"/>
			</p>
			<p>
				<label> 星座 </label> <input id="istar"/>
			</p>
			<p>
				<label> 愛好 </label> <input id="ihobby"/>
			</p>
			<p>
				<label> 头像 </label>
				<img src="" style="width:100px;height:100px" id="ipicture">
			</p>
			<p>
				<label> 注册时间 </label><input id="iregdate"/>
			</p>
			<input type="submit" value="提交"/> <input type="reset" value="重置"/>
		</form>
	</div>
	<script type="text/javascript" src="rel/js/users_info.js"></script>
</body>
</html>