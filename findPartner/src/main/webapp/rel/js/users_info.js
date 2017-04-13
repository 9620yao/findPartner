
//function Query() {
//var wellNo = $('#dg').val(); //得到查询关键字--井号
//alert(wellNo);

////var opts = $('#dg').datagrid('options');
////var page = opts.pageNumber;//获取页码
////var pageSize = opts.pageSize;//获取每页多少记录
////alert()
////var handler = "Ajax/GetWellListHandler.ashx?wellNo=" + escape(wellNo) + "&page=" + escape(page)+ "&pageSize=" + escape(pageSize);

////$('#dg').datagrid('options').url = handler; //设置表格数据的来源URL
////$('#dg').datagrid('reload'); //重新加载表格
//}
/*$.post("",function(data){
	alert(11111);
},"json");*/

$("#dg").datagrid({
	url : 'user/mlist',
	fitColumns:true,
	fit:true,
	pagination:true,
	singleSelect:true,
	columns:[[    
	          {field:'aid',title:'编号',width:50,align:'center'},
	          {field:'nickname',title:'昵称',width:50,align:'center'},
	          {field:'gender',title:'性别',width:50,align:'center',
	        	  formatter: function(value,row,index){
	        		  return row.partner.gender;
	        	  }
	          }, 
	          {field:'email',title:'邮箱',width:100,align:'center',
	        	  formatter: function(value,row,index){
	        		  return row.partner.email;
	        	  }
	          },
	          {field:'birthday',title:'生日',width:50,align:'center'},
	          {field:'star',title:'星座',width:50,align:'center'},
	          {field:'hobby',title:'愛好',width:50,align:'center'},
	          {field:'picture',title:'头像',width:100,align:'center',
	        	  formatter: function(value,row,index){
	        		  if(value == null){
	        			  return "<img width='100' src='images/not_pic.jpg'/>"
	        		  }else{
	        			  return "<img width='100' src='" + value + "'/>"
	        		  }
	        	  }
	          },
	          {field:'regdate',title:'注册时间',width:50,align:'center'},
	          {field:'operator',title:'操作',width:50,align:'center',
	        	  formatter: function(value,row,index){
	        		  return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+index+')">详情</a>'+
	        		  '<script>$(".detailBtn").linkbutton({iconCls:"icon-search"});</script>';
	        	  }
	          }
	          ]]      
});
$("#usersDetail").dialog({
	title:"用户信息",
	left:10,
	closed:true,
});
function showDetail(index){
	$("#usersDetail").dialog("open");
	var row = $("#dg").datagrid("getRows")[index];
	$("#iaid").val(row.aid);
	$("#inickname").val(row.nickname);
	$("#igender").val(row.partner.gender);
	$("#iemail").val(row.partner.email);
	$("#ibirthday").val(row.birthday);
	$("#istar").val(row.star);
	$("#ihobby").val(row.hobby);
	$("#ipicture").attr("src",row.picture=="" ? "images/not_pic.jpg":row.picture);
}





