UE.getEditor('fdesc');
function myadd(){
	alert(1111);
}


//点击提交的时候
function addSpeak(){
	alert(1111);
}

/*<span><a href="" class="blog-color">用户10001昵称</a></span> <span>2015/10/9发表时间</span>
					<h1>
						<a href="">我本楚狂人，凤歌笑孔丘。 我们一直在坚持着，不是为了改变这个世界，而是希望不被这个世界所改变！ </a>
					</h1>*/
function listSpeaks(){
	$.get("speaks/list", function(data){
		var speaksStr = "";

		for (var i = 0; i < data.length; i++) {
			speaksStr+='<article class="am-g blog-entry-article"><div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">';
			speaksStr+=(data[i].files==null || data[i].files=="")?'':'<img src="'+data[i].files+'" alt="" class="am-u-sm-12">';
			speaksStr+='</div><div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text"><span><a href="" class="blog-color">'+data[i].users.nickname+'</a></span><span>'+data[i].senddate+'</span><h1>';
			speaksStr+='<a href="">'+data[i].content+'</a></h1></div></article>';
			//alert(data[i].files);
			//alert( (data[i].files==null || data[i].files=="")? '':'<img src="'+data[i].files+'" alt="" class="am-u-sm-12">');
		}
		
		$("#speaksInfo")[0].innerHTML = speaksStr;
		
	}, "json");
}
listSpeaks();