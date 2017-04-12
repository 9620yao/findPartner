GetFinallyAid();//判断是否隐藏
function GetFinallyAid(){
	$.post("friend/finalAid",function(data){
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		//alert(data.finalaid);
		if(data.finalaid=="-1"){
			$("#myfriend").show();
			$(".updatepwd").show();//修改密码按钮
			$(".homepage").attr("href","page/lw-index.jsp");
			$(".homepage").val("个人中心");
			//$(".updatebtn").show();//修改个人信息按钮
			$(".editdiv").show();
		}else{
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").attr("href","page/lw-index.jsp?aid="+data.finalaid);
			$(".homepage").html("他的主页");
			//$(".updatebtn").hide();
			$(".editdiv").hide();
			
		}
	},"json")
}


var currPage = 1;
function listSpeaks(currPage) {
	$.post("speaks/list",
			{
		"currPage" : currPage
			},
			function(data) {
				if(data==null||data==""){
					return false;
				}
				// alert(data);
				// alert(JSON.stringify(data)); //JSON.stringify()
				// ,把json对象转换成json字符串
				// alert(JSON.stringify(data.rows));
				var speaksStr = "";
				/* var speaksStr2 = ""; */
				for (var i = 0; i < data.rows.length; i++) {
					speaksStr += '<article class="am-g blog-entry-article"><div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">';
					speaksStr += (data.rows[i].files == null || data.rows[i].files == "") ? ''
							: '<img src="' + data.rows[i].files
							+ '" alt="" class="am-u-sm-12">';
					speaksStr += '</div><div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text"><span><a href="" class="blog-color">用户名</a></span><span>'
						+ data.rows[i].senddate + '</span><h1>';
					speaksStr += '<a href="">' + data.rows[i].content
					+ '</a></h1>';
					speaksStr += '<div class="comment"></div></div></article>';
					//alert(data[i].sid);
					comments(data.rows[i].sid);//取到所有的说说编号
				}
				$("#speaksInfo")[0].innerHTML = speaksStr;
				var pagination="";
				pagination+='<label>当前第'+currPage+' 页，共'+data.totalPage+' 页</label>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks(1)">首页</a>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks('+(data.currPage==1?1:(data.currPage-1))+')">上一页</a>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks('+(data.currPage==data.totalPage?data.currPage:(data.currPage+1))+')">下一页</a>';
				pagination+='<a href="javascript:void(0)" onclick="listSpeaks('+data.totalPage+')">尾页</a>';
				$("#page")[0].innerHTML = pagination;
			}, "json");

}
listSpeaks(currPage);

//根据说说编号去查说说下的评论
function comments(sid) {
	// alert(sid);
	$.post("comments/list", {
		"sid" : sid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr += '<p><a href="" class="commentcid">评论用户:'
				+ data[i].comuserid + '</a></p><p><h2>' + data[i].detail
				+ '</h2> <span>评论时间:' + data[i].comTime
				+ '</span></p><div class="reply"></div>';
			replys(data[i].cid);// 取到所有的评论编号
		}
		$(".comment")[0].innerHTML = commentStr;
	}, "json");
}

//根据评论编号，找到评论编号下的所有回复
function replys(cid) {
	// alert(cid);
	$.post("replys/list", {
		"cid" : cid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var replysStr = "";
		for (var i = 0; i < data.length; i++) {
			replysStr += '<p><a href="">用户:' + data[i].ruserid
			+ '</a><a href="">@用户:' + data[i].rtargetid + '</a></p>';
			replysStr += '<p><h2>' + data[i].rcontent + '</h2> <span>回复时间:'
			+ data[i].rtime + '</span></p>';
		}
		$(".reply")[0].innerHTML = replysStr;

	}, "json");
}

function addWinClose() {
	$("#speakComments").dialog("close", true);
	return false;
}

var ue = UE.getEditor('ueditor');

$("#myspeak").form({
	url : "speaks/insert",
	success : function(data) {
		if (data) {
			listSpeaks();
		} else {
			$.messager.alert('增加說說', '增加說說失敗！', 'error');
		}
	}
});
function addSpeak() {
	// alert(ue.getContentTxt());
	$("#content").val(ue.getContentTxt());
	$("#myspeak").submit();
}

$('#speakComments').dialog({
	width : 380,
	height : 500,
	left : 500,
	top : 300,
	title : '',
	border : false,
	modal : true
});

$("#speakComments").dialog("close", true);
