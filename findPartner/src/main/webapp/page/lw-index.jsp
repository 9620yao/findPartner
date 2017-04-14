<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
<base href="${deployName }">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>index | findPartner</title>
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<meta name="mobile-web-app-capable" content="yes">
<link rel="icon" sizes="192x192" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="apple-touch-icon-precomposed"
	href="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileImage"
	content="assets/i/app-icon72x72@2x.png">
<meta name="msapplication-TileColor" content="#0e90d2">
<link type="text/css" rel="stylesheet" href="easyui/themes/icon.css">
<link type="text/css" rel="stylesheet"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" href="assets/css/amazeui.min.css">
<link rel="stylesheet" href="assets/css/app.css">
<link rel="stylesheet" href="rel/css/index.css">
<link rel="stylesheet" href="bootstrap/3.3.4/css/bootstrap.min.css">
</head>
<body id="blog">
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

		<!--工具栏  -->
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

	<!-- content srart -->
	<div class="am-g am-g-fixed blog-fixed">
		<div class="am-u-md-8 am-u-sm-12">
			
			<!-- 个人中心和他的主页 start -->
			<div style="margin-top: 5%;" id="showspeak">

			</div>
			<!-- 个人中心和他的主页  end -->

			<!-- 分页显示数据 start -->
			<div id="page"></div>
			<!-- 分页显示数据 end -->
		</div>

		<div class="am-u-md-4 am-u-sm-12 blog-sidebar">
			<div class="blog-sidebar-widget blog-bor">
				<h2 class="blog-text-center blog-title">
					<span>About ME</span>
				</h2>
				<img src="images/not_pic.jpg" class="pic" width="100" height="100">
				<p>个人简介</p>
				<!-- 显示个人信息 -->
				<div id="myself">
					<!--个人简介 -->
					<table style="margin-left: 10px;">
						<tr>
							<td>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;：</td>
							<td id="inickname"></td>
						</tr>
						<tr>
							<td>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;：</td>
							<td id="iage"></td>
						</tr>
						<tr>
							<td>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;：</td>
							<td id="ibirthday"></td>
						</tr>
						<tr>
							<td>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;：</td>
							<td id="igender"></td>
						</tr>
						<tr>
							<td>星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;座&nbsp;&nbsp;：</td>
							<td id="istar"></td>
						</tr>
						<tr>
							<td>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好&nbsp;&nbsp;：</td>
							<td id="ihobby"></td>
						</tr>
						<tr>
							<td>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;：</td>
							<td id="ijob"></td>
						</tr>
						<tr>
							<td>公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;：</td>
							<td id="icompany"></td>
						</tr>
						<tr>
							<td>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校&nbsp;&nbsp;：</td>
							<td id="ischool"></td>
						</tr>
						<tr>
							<td>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍&nbsp;&nbsp;：</td>
							<td id="iastate"></td>
						</tr>
						<tr>
							<td>现居地址：</td>
							<td id="iaddress"></td>
						</tr>
						<tr>
							<td>家&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡&nbsp;&nbsp;：</td>
							<td id="ihometown"></td>
						</tr>
					</table>
					<button class="updatebtn" data-toggle="modal"
						data-target="#myModal">修改个人信息</button>
				</div>
				<!-- 显示个人信息 end -->
			</div>

			<!-- Modal -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title" id="myModalLabel">修改个人信息</h4>
						</div>
						<!-- addInfo修改个人信息 -->
						<div id="addInfo">
							<h1 id="opt_type">修改个人信息</h1>
							<form action="user/update" id="updateUserInfo" method="post"
								enctype="multipart/form-data">
								<span>个人信息：</span> <input id="aid" name="aid" type="text"
									style="display: block;" />
								<ul>
									<li><input id="pictrue" type="file" name="picData"
										onchange="chgPic(this)" /><br> <img
										src="images/not_pic.jpg" class="pic" width="100" height="100"></li>
									<li>昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称&nbsp;&nbsp;：<input
										type="text" id="nickname" name="nickname"></li>
									<li>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄&nbsp;&nbsp;：<input
										type="text" id="age" name="age"></li>
									<li>生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;：<input
										type="text" id="birthday" name="birthday"></li>
									<li>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别&nbsp;&nbsp;：<input
										type="text" id="gender" name="gender">
									</li>
									<li>星&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;座&nbsp;&nbsp;：<input
										type="text" id="star" name="star"></li>
									<li>爱&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;好&nbsp;&nbsp;：<input
										type="text" id="hobby" name="hobby"></li>
									<li>工&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;：<input
										type="text" id="job" name="job"></li>
									<li>公&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;司&nbsp;&nbsp;：<input
										type="text" id="company" name="company"></li>
									<li>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;校&nbsp;&nbsp;：<input
										type="text" id="school" name="school"></li>
									<li>现居地址：<input type="text" id="address" name="address"></li>
									<li>家&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;乡&nbsp;&nbsp;：<input
										type="text" id="hometown" name="hometown"></li>
									<li>国&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;籍&nbsp;&nbsp;：<input
										type="text" id="astate" name="astate"></li>
								</ul>
								<!-- <a class="updateBtn" href="javascript:void(0)">修改</a> -->
								<button>修改</button>
							</form>
						</div>
						<!-- addInfo修改个人信息  end-->
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!--模态框 end  -->

			<!-- Modal comment -->
			<div class="modal fade" id="addcoment" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<span class="modal-title" id="myModalLabel">添加评论</span>
						</div>
						<div id="comentInfo">
							<div class="showcomment"">
								<form id="faddcomment" action="comments/add" method="post">
									<input name="callid" class="callid" type="hidden">
									<input name="detail" class="detail" type="hidden">
									<div class="democomment" contenteditable="true"></div>
									<a onclick="Getdetail()" href="javascript:void(0)">提交</a>
								</form>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!--模态框 end comment -->

			<!-- Modal reply -->
			<div class="modal fade" id="addreply" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<span class="modal-title" id="myModalLabel">添加回复</span>
						</div>
						<div id="comentInfo">
							<form action="" method="post">
								<div class="democomment" contenteditable="true"></div>
								<button>提交</button>
							</form>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
				</div>
			</div>
			<!--模态框 end reply -->


		</div>
	</div>
	<!-- content end -->

	<footer class="blog-footer">
		<div
			class="am-g am-g-fixed blog-fixed am-u-sm-centered blog-footer-padding">
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h3>模板简介</h3>
				<p class="am-text-sm">
					这是一个使用amazeUI做的简单的前端模板。<br> 博客/ 资讯类 前端模板 <br>
					支持响应式，多种布局，包括主页、文章页、媒体页、分类页等<br>嗯嗯嗯，不知道说啥了。外面的世界真精彩<br> <br>
					Amaze UI 使用 MIT 许可证发布，用户可以自由使用、复制、修改、合并、出版发行、散布、再授权及贩售 Amaze UI
					及其副本。
				</p>
			</div>
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h3>社交账号</h3>
				<p>
					<a href=""><span
						class="am-icon-qq am-icon-fw am-primary blog-icon blog-icon"></span></a>
					<a href=""><span
						class="am-icon-github am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-weibo am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-reddit am-icon-fw blog-icon blog-icon"></span></a> <a
						href=""><span
						class="am-icon-weixin am-icon-fw blog-icon blog-icon"></span></a>
				</p>
				<h3>Credits</h3>
				<p>我们追求卓越，然时间、经验、能力有限。Amaze UI
					有很多不足的地方，希望大家包容、不吝赐教，给我们提意见、建议。感谢你们！</p>
			</div>
			<div class="am-u-sm-12 am-u-md-4- am-u-lg-4">
				<h1>我们站在巨人的肩膀上</h1>
				<h3>Heroes</h3>
				<p>
				<ul>
					<li>jQuery</li>
					<li>Zepto.js</li>
					<li>Seajs</li>
					<li>LESS</li>
					<li>...</li>
				</ul>
				</p>
			</div>
		</div>
		<div class="blog-text-center"></div>
	</footer>

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="assets/js/jquery.min.js"></script>
	<script src="bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<!--<![endif]-->
	<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="assets/js/amazeui.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/ueditor.all.min.js"></script>
	<script type="text/javascript" charset="utf-8"
		src="rel/ueditor/lang/zh-cn/zh-cn.js"></script>
	<script src="rel/layer/jquery.js?v=1.83.min"></script>
	<script src="rel/layer/layer.min.js"></script>
	<script type="text/javascript" src="rel/js/hpindex.js"></script>
	<script type="text/javascript" src="rel/js/index.js"></script>
	<script type="text/javascript" src="rel/js/indexpic.js"></script>
</body>
</html>