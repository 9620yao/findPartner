/*<span><a href="" class="blog-color">用户10001昵称</a></span> <span>2015/10/9发表时间</span>
					<h1>
						<a href="">我本楚狂人，凤歌笑孔丘。 我们一直在坚持着，不是为了改变这个世界，而是希望不被这个世界所改变！ </a>
					</h1>*/
function listSpeaks(){
	$.get("speaks", function(data){
		alert("请求响应成功。。"+data);
		alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串
		
	}, "json");
}
listSpeaks();