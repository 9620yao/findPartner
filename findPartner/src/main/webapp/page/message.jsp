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
			<ul class="am-nav am-nav-pills am-topbar-nav" id="head">
				<li class="am-active"><a class="homepage"
					href="page/lw-index.jsp">个人中心</a></li>
				<li id="myfriend" class="am-dropdown" data-am-dropdown><a
					class="am-dropdown-toggle" data-am-dropdown-toggle
					href="javascript:;">好友信息 <span class="am-icon-caret-down"></span>
				</a>
					<ul class="am-dropdown-content">
						<li><a href="page/lw-friend.jsp">我的好友</a></li>
						<li><a href="page/lw-findFriend.jsp">添加好友</a></li>
					</ul></li>
				<li><a href="page/lw-speaks.jsp">说说</a></li>
				<li><a href="page/message.jsp">留言</a></li>
				<li><a href="page/lw-img.jsp">相册</a></li>
				<li><a class="updatepwd" href="page/lw-modifyPwd.jsp">修改密码</a></li>
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

	<div id="Userimag" style="margin-left: 7%">
		<!-- <label>个人照片</label>
		<p>
			<img src="assets/i/b3.jpg" width=100px; height=100px;>
		</p> -->
	</div>

	<!-- hostAll start -->
	<div id="hostAll" style="margin-top: 3%;">
		<!-- <hr>
		<div id="host">
			<div class="showwords">
				<ul id="everyLiTag">
					<li style="color: blue;" class="aaa26">用户头像</li>
					<li style="color: blue;" class="name">好友编号</li>
					<li><span>留言内容</span></li>
					<li style="color: grey;" class="wdate">留言时间</li>
					<a>回复</a>
				</ul>
			</div>
			<div class="showcomment">
				<ul class="pinglun">
					<li style="color: blue;" class="aaa29"></li>
					<li style="color: blue;" class="a29name">评论编号</li>
					<li style="color: grey;" class="wdate" id='aa29'>评论时间</li>
					<li><span class="wcontenta29">评论内容</span></li>
					<textarea class="wcontenta29">评论内容</textarea>
				</ul>
			</div>
			<div class="showreplys">
				<ul class="huifu">
					<li style="color: blue;" class="huiaa26"></li>
					<li style="color: blue;" class="huiaa26name">回复编号</li>
					<li style="color: grey;" class="huiaa26wdate">回复时间</li>
					<textarea id="edit" name="edit" class="huiaa26edit">回复内容</textarea>
				</ul>
			</div>
		</div> -->
		<a class="huibianjia26" href="javascript:void(0)" onclick="add();"
			style="color: black; margin-left: 20%;">评论</a>

	</div>
	<br><br><br><br>
	<div id="leaveMsg">
		<label style="color: #9c9c9c">发表留言</label>
		<textarea type="text" style="width: 500px"></textarea>
	</div>
	<br><br><br><br>
	<div id="page"></div>
	<!-- hostAll end -->

	<!-- 
	<div id="leaveMsg">
		<label style="color: #9c9c9c">发表留言</label>
		<textarea type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<br>
	<div id="comWords">
		<label style="color: #9c9c9c">评论留言</label>
		<textarea type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div>
	<br>
	<div id="replyhost">
		<label style="color: #9c9c9c">回复评论</label>
		<textarea type="text" style="width: 500px"></textarea>
		<button type="submit" class="fabiao-btn">发表</button>
		<button type="reset" class="quxiao_btn">取消</button>
	</div> -->

	<script src="assets/js/jquery.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="rel/js/message.js"></script>

</body>
</html>