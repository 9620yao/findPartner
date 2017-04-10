<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<base href="${deployName }">
<meta charset="UTF-8">
<title>忘记密码</title>
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet" href="easyui/themes/default/easyui.css">
<link type="text/css" rel="stylesheet" href="rel/css/forgetPassword.css">
</head>
<body>
	<div id="forgrtPwdDiv">
		<form action="user/forget" id="forgetForm" method="post">
			<p>
				<input name="username" required="required" placeholder="请求输入用户名" />
			</p>
			<p>
				<input type="email" name="email" required="required"
					placeholder="请求输入找出密码邮箱" />
			</p>
			<p>
				<button>找回密码</button>
			</p>
		</form>
	</div>
	
	<script type="text/javascript" src="easyui/jquery.min.js"></script>
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="rel/js/forgetPassword.js"></script>
</body>
</html>