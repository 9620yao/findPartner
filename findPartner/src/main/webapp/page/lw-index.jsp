<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
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
<link rel="stylesheet" href="rel/css/speak.css">
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

		<div class="am-collapse am-topbar-collapse" id="blog-collapse">
			<ul class="am-nav am-nav-pills am-topbar-nav" id="head">
				<li class="am-active"><a href="page/lw-index.jsp">个人中心</a></li>
				<li class="am-dropdown" data-am-dropdown><a
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
				<li><a href="page/lw-modifyPwd.jsp">修改密码</a></li>
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
			<article class="am-g blog-entry-article">
				<div class="editdiv">
					<form id="myspeak" method="post">
						<textarea onclick="myadd()" id="fdesc" name="fdesc" rows="4"
							cols="39" placeholder="发表一个说说"></textarea>
						<button onclick="addSpeak()">发表</button>
					</form>
				</div>
			</article>
			<br> <br>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<!-- <img src="assets/i/f10.jpg" alt="" class="am-u-sm-12"> -->
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article &nbsp;</a></span> <span>
						@amazeUI &nbsp;</span> <span>2015/10/9</span>
					<h1>
						<a href="">我本楚狂人，凤歌笑孔丘</a>
					</h1>
					<p>我们一直在坚持着，不是为了改变这个世界，而是希望不被这个世界所改变。</p>
					<p>
						<a href="" class="blog-continue">continue reading</a>
					</p>
				</div>
			</article>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<img src="assets/i/f6.jpg" alt="" class="am-u-sm-12">
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article&nbsp;</a></span> <span>@amazeUI
						&nbsp;</span> <span>2015/10/9</span>
					<h1>
						<a href="">世间所有的相遇，都是久别重逢。</a>
					</h1>
					<p>你可以选择在原处不停地跟周遭不解的人解释你为何这么做，让他们理解你，你可以选择什么都不讲，自顾自往前走。</p>
					<p>
						<a href="" class="blog-continue">continue</a>
					</p>
				</div>
			</article>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<img src="assets/i/f12.jpg" alt="" class="am-u-sm-12">
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article&nbsp;</a></span> <span>@amazeUI</span>
					<span>2015/10/9</span>
					<h1>
						<a href="">陌上花开，可缓缓归矣。</a>
					</h1>
					<p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。我们就在骑楼下躲雨，看绿色的邮筒孤独地站在街的对面。
					</p>
					<p>
						<a href="" class="blog-continue">continue</a>
					</p>
				</div>
			</article>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<img src="assets/i/f22.jpg" alt="" class="am-u-sm-12">
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article&nbsp;</a></span> <span>@amazeUI</span>
					<span>2015/10/9</span>
					<h1>
						<a href="">爱自己是终生浪漫的开始</a>
					</h1>
					<p>the whole of life becomes an act of letting go, but what
						always hurts the most is not taking a moment to say goodbye</p>
					<p>
						<a href="" class="blog-continue">continue</a>
					</p>
				</div>
			</article>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<img src="assets/i/f18.jpg" alt="" class="am-u-sm-12">
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article&nbsp;</a></span> <span>
						@amazeUI &nbsp;</span> <span>2015/10/9</span>
					<h1>
						<a href="">My dear amazeUI, Hello </a>
					</h1>
					<p>那时候刚好下着雨，柏油路面湿冷冷的，还闪烁着青、黄、红颜色的灯火。我们就在骑楼下躲雨，看绿色的邮筒孤独地站在街的对面。
					</p>
					<p>
						<a href="" class="blog-continue">continue reading</a>
					</p>
				</div>
			</article>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<img src="assets/i/f20.jpg" alt="" class="am-u-sm-12">
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article&nbsp;</a></span> <span>
						@amazeUI &nbsp;</span> <span>2015/10/9</span>
					<h1>
						<a href="">My way or the highway</a>
					</h1>
					<p>A big wind rises， clouds are driven away. Home am Inow the
						world is under my sway. Where are brave men to guard the four
						frontiers today！</p>
					<p>
						<a href="" class="blog-continue">continue reading</a>
					</p>
				</div>
			</article>

			<article class="am-g blog-entry-article">
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
					<img src="assets/i/f19.jpg" alt="" class="am-u-sm-12">
				</div>
				<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
					<span><a href="" class="blog-color">article&nbsp;</a></span> <span>
						@amazeUI &nbsp;</span> <span>2015/10/9</span>
					<h1>
						<a href="">一想到你，我这张丑脸上就泛起微笑</a>
					</h1>
					<p>那一天我二十一岁，在我一生的黄金时代。我有好多奢望。我想爱，想吃，还想在一瞬间变成天上半明半暗的云。</p>
					<p>
						<a href="" class="blog-continue">continue reading</a>
					</p>
				</div>
			</article>

			<ul class="am-pagination">
				<li class="am-pagination-prev"><a href="">&laquo; Prev</a></li>
				<li class="am-pagination-next"><a href="">Next &raquo;</a></li>
			</ul>
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
					<button onclick="add()">修改个人信息</button>
				</div>
				<!-- 显示个人信息 end -->
			</div>

			<!-- addInfo修改个人信息 -->
			<div id="addInfo">
				<h1 id="opt_type">修改个人信息</h1>
				<form id="updateUserInfo" method="post"
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
					<button onclick="return addWinClose();">&nbsp;&nbsp;取
						消&nbsp;&nbsp;</button>
					&nbsp;&nbsp;
				</form>
			</div>
			<!-- addInfo修改个人信息  end-->
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
	<script type="text/javascript" src="rel/js/index.js"></script>
</body>
</html>