
//function Query() {
//    var wellNo = $('#dg').val(); //得到查询关键字--井号
//    alert(wellNo);
//
//    //var opts = $('#dg').datagrid('options');
//    //var page = opts.pageNumber;//获取页码
//    //var pageSize = opts.pageSize;//获取每页多少记录
//    //alert()
//    //var handler = "Ajax/GetWellListHandler.ashx?wellNo=" + escape(wellNo) + "&page=" + escape(page)+ "&pageSize=" + escape(pageSize);
//
//    //$('#dg').datagrid('options').url = handler; //设置表格数据的来源URL
//    //$('#dg').datagrid('reload'); //重新加载表格
//}
$("#dg").datagrid({
	url : 'news/list',
	fitColumns:true,
    fit:true,
	pagination:true,
	singleSelect:true,
	columns:[[    
	          {field:'nid',title:'编号',width:50,align:'center'}, 
	          {field:'ntid',title:'类型',width:50,align:'center',
	        	  formatter: function(value,row,index){
						return row.topic.tname;
					}
	          }, 
	          {field:'ntitle',title:'题目',width:100,align:'center'},    
	          {field:'nauthor',title:'作者',width:100,align:'center'}, 
	          {field:'operator',title:'操作',width:50,align:'center',
	        	  formatter: function(value,row,index){
					return '<a class="detailBtn" href="javascript:void(0)" onclick="showDetail('+row.nid+')">详情</a>'+
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
/*function showDetail(id){
	$("#newsDetail").dialog("open");
	$.post("news/get?nid="+id,function(data){
		$("#intname").val(data.topic.tname);
		$("#intitle").val(data.ntitle);
		$("#inauthor").val(data.nauthor);
		$("#insummary").val(data.nsummary);
		$("#incontent").html(data.ncontent);
		$("#ipic").attr("src",data.npicpath=="" ? "images/IMG_0933.JPG":data.npicpath);
	},"json");
}*/





