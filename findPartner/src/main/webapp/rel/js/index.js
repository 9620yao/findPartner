UE.getEditor('fdesc');
function myadd(){
	alert(1111);
}


//点击提交的时候
function addSpeak(){
	alert(1111);
}

function loadAdminInfo(){
	//以异步的方式取到个人的信息
	$.get("user/getByid", function(data){
		//alert("请求响应成功。。"+data);
		//alert(JSON.stringify(data));  //JSON.stringify() ,把json对象转换成json字符串

		showUserInfo(data);
		showUser(data);
	}, "json");
}
loadAdminInfo();

//显示个人信息
function showUserInfo(data){
	$("#pictrue").val("");
	if(data.picture){
		$(".pic").attr("src", data.picture);
	}else{
		$(".pic").attr("src", "images/not_pic.jpg");
	}
	$("#inickname").append(data.nickname);
	$("#iage").append(data.age);
	$("#ibirthday").append(data.birthday);
	$("#igender").append(data.partner.gender);
	$("#istar").append(data.star);
	$("#ihobby").append(data.hobby);
	$("#ijob").append(data.job);
	$("#icompany").append(data.company);
	$("#ischool").append(data.school);
	$("#iastate").append(data.astate);
	$("#iaddress").append(data.address);
	$("#ihometown").append(data.hometown);
	$("#iastate").append(data.astate);
}

//显示个人信息
function showUser(data){
	$("#pictrue").val("");
	if(data.picture){
		$(".pic").attr("src", data.picture);
	}else{
		$(".pic").attr("src", "images/not_pic.jpg");
	}
	//alert(data.aid)
	$("#aid").val(data.aid);
	$("#nickname").val(data.nickname);
	$("#age").val(data.age);
	$("#birthday").val(data.birthday);
	$("#gender").val(data.partner.gender);
	$("#star").val(data.star);
	$("#hobby").val(data.hobby);
	$("#job").val(data.job);
	$("#company").val(data.company);
	$("#school").val(data.school);
	$("#astate").val(data.astate);
	$("#address").val(data.address);
	$("#hometown").val(data.hometown);
	$("#astate").val(data.astate);
}

$('#addInfo').dialog({    
	width:380,
	height:500,
	left:500,
	top:800,
	title:'',
	border:false,
	modal: true
});   


$("#addInfo").dialog("close", true);


function add(){
	$("#aid").hide();
	$("#addInfo").dialog("open", true);
}

function addWinClose(){
	$("#addInfo").dialog("close", true);
	return false;
}

$(".updateBtn").linkbutton({
	iconCls: "icon-ok",
	onClick: function(){
		$("#updateUserInfo").submit();
	} 	
});


$("#updateUserInfo").form({
	url:"user/update",    
    success:function(data){
    	//alert(JSON.stringify(data));
    	if(data == ""){
    		$.messager.alert('用户修改主','当前用户没有修改用户的权限 ！','warning');
    		$("#addInfo").dialog("close"); //关闭修改框
    		return ;
    	}

    	if(data.trim() == "true"){
    		$("#addInfo").dialog("close"); //关闭修改框
    		loadAdminInfo();
    	}else{
    		$.messager.show({
    			title:'修改信息',
    			msg:'修改失败！！！',
    			showType:'show',
    			style:{
    				top:document.body.scrollTop+document.documentElement.scrollTop,
    			}
    		});
    	}
    } 
});
function chgPic(obj){
	$(".pic").attr("src", window.URL.createObjectURL(obj.files[0]));
}

$(function(){
	$("#head li a").on("click",function(){
	$("#head li a").css("background-color","white");
	$(this).css("background-color","green");
	})
	});