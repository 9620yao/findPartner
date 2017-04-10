GetFinallyAid();
function GetFinallyAid() {
	$.post("friend/finalAid", function(data) {
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify() ,把json对象转换成json字符串
		// alert(data.finalaid);
		if (data.finalaid == "-1") {
			$(".myfriend").show();
			$(".updatepwd").show();
			$(".homepage").attr("href", "page/lw-index.jsp");
			$(".homepage").val("个人中心");
			// $(".updatebtn").show();
			$(".addimgbtn").show();
			$(".newimgbtn").show();
		} else {
			$(".myfriend").hide();
			$(".updatepwd").hide();
			$(".homepage").attr("href",
					"page/lw-index.jsp?aid=" + data.finalaid);
			$(".homepage").html("他的主页");
			// $(".updatebtn").hide();
			$(".addimgbtn").hide();
			$(".newimgbtn").hide();
		}
	}, "json")
}

//加载相册
listalbumpic();
function listalbumpic() {
	$.post("albumpic/list", function(data) {
		if (data == null || data == "") {
			$(".imgnotnull").show();//显示添加图片img标签
			$(".addimgbtn").hide();//
			return false;
		}
		$("#imgnotnull").hide();//显示添加图片img标签
		// alert(data);
		// alert(JSON.stringify(data)); //JSON.stringify()// ,把json对象转换成json字符串
		var albumpicStr = "";
		for (var i = 0; i < data.length; i++) {
			albumpicStr += '<img src="' + data[i].apic
			+ '" layer-pname="代码笔记 - ' + data[i].apic + '">';
			albumpicStr += '<input type="hidden" class="apiccontent"  value="'
				+ data[i].apiccontent + '">';
		}
		$("#imgs")[0].innerHTML = albumpicStr;
	}, "json")
}
//alert($(".apiccontent").html());

function chgPic(obj){
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

;
!function() {
	layer.use('extend/layer.ext.js', function() {
		// 初始加载即调用，所以需放在ext回调里
		layer.ext = function() {
			layer.photosPage({
				html : '<div style="padding:20px;">'
					+ ($("apiccontent").html())
					+ '<p>相册支持左右方向键，支持Esc关闭</p><p id="change"></p></div>',
					title : '快捷模式-获取页面元素包含的所有图片',
					id : 100, // 相册id，可选
					parent : '#imgs'
			});
		};
	});
}();
//<div
//style="padding:20px;">这里传入自定义的html<p>相册支持左右方向键，支持Esc关闭</p><p>另外还可以通过异步返回json实现相册。更多用法详见官网。</p><p>'+
//unescape("代码笔记 www.198zone.com") +'</p><p id="change"></p></div>

