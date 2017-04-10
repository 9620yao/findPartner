<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<base href="${deployName}">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言板</title>
<link rel="stylesheet" href="assets/css/message.css">
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
</head>
<body>
	<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
		<div class="am-u-sm-8 am-u-sm-centered">
			<!-- <img width="200" src="assets/i/amazeui-b.png" alt="Amaze UI Logo" /> -->
			<h2 class="am-hide-sm-only">findPartner | 校园首个交互网站</h2>
		</div>
	</header>
	<hr>
	<!-- nav start -->
	<nav class="am-g am-g-fixed blog-fixed blog-nav">
		<button
			class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only blog-button"
			data-am-collapse="{target: '#blog-collapse'}">
			<span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span>
		</button>

		<div class="am-collapse am-topbar-collapse" id="blog-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav">
				<li class="am-active"><a href="page/lw-index.jsp">个人中心</a></li>
				<li><a href="javascript:void(0)">发现好友</a></li>
				<li><a href="page/lw-speaks.jsp">说说</a></li>
				<li><a href="page/message.jsp">留言</a></li>
				<li><a href="page/lw-img.jsp">相册</a></li>
			</ul>
			<form class="am-topbar-form am-topbar-right am-form-inline"
				role="search">
				<div class="am-form-group">
					<input type="text" class="am-form-field am-input-sm"
						placeholder="搜索">
				</div>
			</form>
		</div>
	</nav>
	<hr>
	<!-- nav end -->

	<div id="Userimag">
		<label>个人照片</label><img src="assets/i/b3.jpg" width=200px;
			height=200px;>
	</div>

	<div id="host">
		<form action="words/findWords" method="POST" id="myForm">
			<label>显示您的留言</label>
			<div id="everyLiTag">
					<!-- 显示留言 -->
					<div id="wordsInfo">
						<span style="color: blue;" class="aaa26">被留言的用户</span>
						<span style="color: blue;" id="wfrendid" name="wfrendid">留言人</span>
						<span style="color: grey;" class="wdate" id="wdate" name="wdate">留言日期</span>
						<span id="waddress" name="waddress">留言地址</span>
						<textarea class="wcontent" id="wcontent" name="wcontent">留言内容</textarea>
					</div>
					<div class="comment">
							<input style="color: blue;" class="aaa29"/>
							<span style="color: blue;" class="a29name">${s.comuserid}</span>
							<span style="color: grey;" class="wdate" id="wcontent" name="wcontent">评论时间</span>
							<textarea class="wcontenta29" id="detail" name="detail">评论内容</textarea>
					</div>
					<br>

					<div class="huifu">
							<span style="color: blue;" class="huiaa26name"></span>
							<span style="color: grey;" class="huiaa26wdate"></span>
							<input id="edit" name="edit" class="huiaa26edit">
							<a class="huibianjia26" href="javascript:void(0)"
								onclick="add();" style="color: red;">编辑</a>
							<a class="huifabiaoa26" href="javascript:void(0)"
								style="color: red;">发表</a>
					</div>
			</div>
			<br>
			<button   style="height: 30px; margin-top: -160px;">查看留言以及回复评论</button>
		</form>
	</div>
	<br>
	<div id="leaveMsg">
		<label style="color: #9c9c9c">发表留言</label>

		<textarea id="ueditor" name="ueditor" type="text" style="width: 300px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<br>
	<div id="comWords">
		<label style="color: #9c9c9c">评论留言</label>
		<textarea id="ueditor" name="ueditor" type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<br>
	<div id="replyhost">
		<label style="color: #9c9c9c">回复评论</label>
		<textarea id="ueditor" name="ueditor" type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.all.min.js">
		
	</script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="rel/js/message.js"></script>
</body>
</html>