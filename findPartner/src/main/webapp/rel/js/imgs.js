//加载所有相册
function showalbum() {
	$.post("album/list", function(data) {
		//alert("请求响应成功。。"+data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		var album = '';
		for(var i=0;i<data.length;i++){
			album+= '<div><img onclick="openpic()" src="'+data[i].aheader+'"><h2>'+data[i].abname+'</h2></div>';
		}
		$("#container").html(album);
	}, "json");
}
showalbum();

//点击相册
function openpic(){
	alert(111);
	var url = "page/albumpic.jsp?"+12345;
	//window.open(url); //打开新的页面并带参数过去 
	self.location = url;//挑战页面
	//url:"albumpic.jsp"
}