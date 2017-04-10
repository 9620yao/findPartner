//UE.getEditor('ueditor');

/*function add(){
	UE.getEditor('edit');//<textarea>转变成副文本编辑工具
	$("#host").dialog("open", true);
}*/
//$("#host").dialog("close", true);

/*$('#host').dialog({    
	width:100,
	height:300,
	left:300,
	top:200,
	title:'',
	border:false,
	modal: true
});*/
/*$(function(){
    $('#myForm').submit();
})*/
/*
window.onload= function(){
   document.getElementById('myForm').submit();
}*/

listWords();
function listWords(){
	$.post("words/findWords", function(data){
		alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var wordsStr = "";
		for (var i = 0; i < data.length; i++) {
			wordsStr+='<span style="color:blue;" class="aaa26"></span>'; 
			wordsStr+='<span style="color:blue;" class="name">'+data[i].wfrendid+'</span>';
			wordsStr+='<span style="color:grey;" class="wdate">'+data[i].wdate+'</span>';
			wordsStr+='<span>'+data[i].waddress+'</span>';
			wordsStr+='<textarea  class="wcontent">'+data[i].wcontent+'</textarea>';
			
			comments(data[i].sid);//取到所有的说说编号
		}
		$("#wordsInfo")[0].innerHTML = wordsStr;
	}, "json");
}


//根据说说编号去查说说下的评论
function comments(sid){
	$.post("comments/list",{"sid":sid}, function(data){
		//alert(data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		var commentStr = "";
		for (var i = 0; i < data.length; i++) {
			
			commentStr+='<li style="color: blue;" class="aaa29"></li>';
			commentStr+='<li style="color: blue;" class="a29name">'+data[i].comuserid+'</li>';
			commentStr+='<li style="color: grey;" class="wdate">'+data[i].comTime+'</li>';
			commentStr+='<textarea class="wcontenta29">'+data[i].detail;
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
listWords();