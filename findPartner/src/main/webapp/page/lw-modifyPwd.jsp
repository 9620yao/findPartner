<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta  charset="UTF-8">
<title>修改密码</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="rel/css/modifyPwd.css">
</head>
<body>
	<div id="modifyPwd">
				<form method="post" id="modifyForm" action="partner/mofifyPwd">
					<p>
						<label style="color: red;">${errorMsg}&nbsp;</label>
					</p>
					<p><input type="text" id="email" name="email" placeholder="请输入邮箱" required="required"></p>
					<p><input type="password" id="password" name="password" placeholder="请输入原密码" required="required"></p>
					<p><input type="password" id="newPassword" name="newPassword" placeholder="请输入新密码" required="required"></p>
					<p><button type="submit">修改</button><a href="page/lw-index.jsp">退出</a>
					&nbsp;&nbsp;
				</form>
			</div>	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="rel/js/modifyPwd.js"></script>
</body>
</html>
