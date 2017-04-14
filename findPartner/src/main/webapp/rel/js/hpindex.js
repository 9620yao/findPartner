GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", function(data) {
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(data.finalaid);
		if (data.finalaid == "-1") {
			$("#myfriend").show();
			$(".updatepwd").show();
			$(".updatebtn").show();
			$(".homepage").attr("href", "page/lw-index.jsp");
			$(".homepage").val("个人中心");
			selfhomepage(currPage);//是自己页面的时候显示个人中心
		} else {
			$("#myfriend").hide();
			$(".updatepwd").hide();
			$(".updatebtn").hide();
			$(".homepage").attr("href",
					"page/lw-index.jsp?aid=" + data.finalaid);
			$(".homepage").html("他的主页");
			showhomepage(currPage);//是好友页面的时候显示他的主页
		}
	}, "json")
}

var currPage = 1;
//显示他的主页
function showhomepage(currPage) {
	$.post("homepage/list",
			{
		"currPage" : currPage
			},
			function(data) {
				if (data == null || data == "") {
					return false;
				}
				homepage(data);
				
				//alert(JSON.stringify(data));
				var pagination = "";
				//console.info(data.currPage+"|"+data.totalPage);
				if(data.currPage == data.totalPage){
					pagination += '<div><a class="addmore" href="javascript:void(0)">已经到底部</a></div>';
				}else{
					pagination += '<div><a class="addmore" href="javascript:void(0)" onclick="showhomepage('+(data.currPage+1)+')">点击加载更多</a></div>';
				}
				//alert(pagination);
				$("#page")[0].innerHTML = pagination;
			}, "json");
}

//显示个人中心
function selfhomepage(currPage) {
	$.post("homepage/selflist",
			{
		"currPage" : currPage
			},
			function(data) {
				if (data == null || data == "") {
					return false;
				}
				homepage(data);
				//alert(JSON.stringify(data));
				var pagination = "";
				//console.info(data.currPage+"|"+data.totalPage);
				if(data.currPage == data.totalPage){
					pagination += '<div><a class="addmore" href="javascript:void(0)">已经到底部</a></div>';
				}else{
					pagination += '<div><a class="addmore" href="javascript:void(0)" onclick="selfhomepage('+(data.currPage+1)+')">点击加载更多</a></div>';
				}
				//alert(pagination);
				$("#page")[0].innerHTML = pagination;
			}, "json");
}


//避免重复调用
function homepage(data){
	//alert(JSON.stringify(data)); // JSON.stringify()
	//取到编号和用户编号
	for(var i=0;i<data.rows.length;i++){
		findspeack(data.rows[i].hpid,data.rows[i].hpuseid,data.rows[i].hpdate);
		findalbumpic(data.rows[i].hpid,data.rows[i].hpuseid,data.rows[i].hpdate);
	}
}

//同步发送请求
function findspeack(sid,speakman,senddate){
	$.ajax({
		type: "POST",
		url: "speaks/hpspeaks",
		data:{"sid":sid,"speakman":speakman},
		async: false,//同步加载
		dataType: "json",
		success: function(data){
			if(data==null ||data ==""){
				//findalbumpic(sid,speakman,senddate);
				return false;
			}
			//console.info(data);
			var speaksStr = "";
			//alert(data);
			speaksStr+='<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			speaksStr+='<a href="javascript:void(0)">'+data.speakman+'</a>';
			speaksStr+='<br><span style="margin-left: 5%;">'+data.senddate+'</span>';
			speaksStr+='<div class="demoEdit" contenteditable="true">'+data.content+'</div>';
			speaksStr+='<a style="margin-left: 23%;" href="javascript:void(0)">删除</a>';
			speaksStr+='<a onclick="addcomment(\''+data.sid+'\')" href="javascript:void(0)" style="margin-left: 5%;" data-toggle="modal"';
			speaksStr+=' data-target="#addcoment">评论</a></p>';
			speaksStr+='</div><div class="comment'+data.sid+'" style="margin-left: 5%;"><div>';
			//alert(data[i].sid);
			comments(data.sid);//取到所有的说说编号
			//alert(speaksStr);
			$("#showspeak").append(speaksStr);
			//$("#showspeak")[0].innerHTML = speaksStr;
		}
	});
}

function comments(sid) {
	// alert(sid);
	$.post("comments/list", {
		"sid" : sid
	}, function(data) {
		if (data == null || data == "") {
			return false;
		}
		// alert(data);
		//alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr += '<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			commentStr += '<a href="javascript:void(0)">'+data[i].comuserid+'</a>';
			commentStr += '<br><span style="margin-left: 5%;">'+data[i].comTime+'</span>';
			commentStr += '<div class="demoEdit" contenteditable="true">'+data[i].detail+'</div>';
			commentStr += '<a style="margin-left: 23%;" href="javascript:void(0)">删除</a>';
			commentStr += '<a href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
			commentStr += ' data-target="#addreply">回复</a>';
			commentStr += '</div><div class="reply'+data[i].cid+'" style="margin-left: 5%;"></div>';
			replys(data[i].cid);// 取到所有的评论编号
		}
		//alert($(".comment"+sid)[0].innerHTML);
		$(".comment"+sid)[0].innerHTML = commentStr;
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
			replysStr += '<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			replysStr += '<a href="javascript:void(0)">'+data[i].ruserid+'</a> 回复';
			replysStr += '<a href="javascript:void(0)">'+data[i].rtargetid+'</a>:';
			replysStr += '<br><span style="margin-left: 5%;">'+data[i].rtime+'</span>';
			replysStr += '<div class="demoEdit" contenteditable="true">'+data[i].rcontent+'</div>';
			replysStr += '<a style="margin-left: 23%;" href="javascript:void(0)">删除</a>';
			replysStr += '<a href="javascript:void(0)" style="margin-left: 5%;"  data-toggle="modal"';
			replysStr += ' data-target="#addreply">回复</a></div>';
		}
		$(".reply"+cid)[0].innerHTML = replysStr;
	}, "json");
}

function findalbumpic(abid,speakman,apicdate){
	$.ajax({
		type: "POST",
		url: "albumpic/hpalbumpic",
		data:{"abid":abid,"apicdate":apicdate},
		async: false,//同步加载
		dataType: "json",
		success: function(data){
			if(data==null ||data ==""){
				//findspeack(abid,speakman,apicdate);
				return false;
			}
			//alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
			var imgpic = "";
			imgpic+='<div><img style="width: 20px; height: 20px;" src="images/01.jpg">';
			imgpic+='<a href="javascript:void(0)">用户名：</a>';
			imgpic+='<br><span style="margin-left: 5%;">'+data.apicdate+'</span>';
			imgpic+='<div id="imgs" class="imgs">';
			imgpic+='<img src="'+data.apic+'">';
			imgpic+='</div><p style="margin-left: 3%;">上传图片到《';
			imgpic+='<a  href="javascript:void(0)">相册'+data.abid+'</a>》</p></div>';
			$("#showspeak").append(imgpic);
		}
	});
}

//点击评论
function addcomment(obj){
	//alert(obj);
	//$(".callid").attr("value",sid);
	$(".callid").attr("value",obj);
}

/*$("#faddcomment").form({
	url : "",
	success : function(data) {
		if (data) {
			//listSpeaks();
			alert(data);
		} else {
			$.messager.alert('增加說說', '增加說說失敗！', 'error');
		}
	}
});*/

//点击提交
function Getdetail(){
	var text = $(".democomment").text();
	//alert(text);
	$(".detail").attr("value",text);
	$("#faddcomment").submit();
}

