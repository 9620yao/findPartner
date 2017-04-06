var ue=UE.getEditor('ueditor');

$("#myspeak").form({
	url:"speaks/insert",       
	success:function(data){
    	 if(data){
    		 listSpeaks();
         }else{
         	$.messager.alert('增加說說','增加說說失敗！','error');
         }
    }
});
function addSpeak(){
	//alert(ue.getContentTxt());
	$("#content").val(ue.getContentTxt());
	$("#myspeak").submit();
}

listSpeaks();
function listSpeaks(){
	$.post("speaks/list", function(data){
		//alert(data);
		alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		//alert(JSON.stringify(data.rows));
		var speaksStr = "";
		for (var i = 0; i < data.rows.length; i++) {
			speaksStr+='<article class="am-g blog-entry-article"><div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">';
			speaksStr+=(data.rows[i].files==null || data.rows[i].files=="")?'':'<img src="'+data.rows[i].files+'" alt="" class="am-u-sm-12">';
			speaksStr+='</div><div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text"><span><a href="" class="blog-color">用户名</a></span><span>'+data.rows[i].senddate+'</span><h1>';
			speaksStr+='<a href="">'+data.rows[i].content+'</a></h1>';
			speaksStr+='<div class="comment"></div></div></article>';
			//alert(data[i].sid);
			comments(data.rows[i].sid);//取到所有的说说编号
		}
		$("#speaksInfo")[0].innerHTML = speaksStr;
	}, "json");
}


//根据说说编号去查说说下的评论
function comments(sid){
	$.post("comments/list",{"sid":sid}, function(data){
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			commentStr+='<p><a href="" class="commentcid">评论用户:'+data[i].comuserid+'</a></p><p><h2>'+data[i].detail+'</h2> <span>评论时间:'+data[i].comTime+'</span></p><div class="reply"></div>';
			replys(data[i].cid);//取到所有的评论编号
		}
		$(".comment")[0].innerHTML = commentStr;
	}, "json");
}

//根据评论编号，找到评论编号下的所有回复
function replys(cid){
	//alert(cid);
	$.post("replys/list",{"cid":cid}, function(data){
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var replysStr = "";
		for (var i = 0; i < data.length; i++) {
			replysStr+='<p><a href="">用户:'+data[i].ruserid+'</a><a href="">@用户:'+data[i].rtargetid+'</a></p>';
			replysStr+='<p><h2>'+data[i].rcontent+'</h2> <span>回复时间:'+data[i].rtime+'</span></p>';
		}
		$(".reply")[0].innerHTML = replysStr;
		
	}, "json");
}
listSpeaks();
$('#speakComments').dialog({    
	width:380,
	height:500,
	left:500,
	top:300,
	title:'',
	border:false,
	modal: true
});

$("#speakComments").dialog("close", true);


function comments(sid){
	$("#speakComments").dialog("open", true);
	$.get("speaks/"+sid, function(data){
		//alert("请求响应成功。。"+data);
		//alert(JSON.stringify(data));
		var commentsStr = "";
		for (var i = 0; i < data.length; i++) {
			commentsStr+='<div style="float:left;">';
			commentsStr+=(data[i].files==null || data[i].files=="")?'':'<img src="'+data[i].users.picture+'">';
			commentsStr+='<div style="float:left;"><span>'+data[i].users.nickname+'</span><span>'+data[i].detail+'</span><br>';
			commentsStr+='<span>'+data[i].comTime+'</span>&nbsp;&nbsp;&nbsp;&nbsp;<a href="">回复</a><br></div>';
		}
		
		$("#commentsInfo")[0].innerHTML = commentsStr;
		
	}, "json");
}

function addWinClose(){
	$("#speakComments").dialog("close", true);
	return false;
}

