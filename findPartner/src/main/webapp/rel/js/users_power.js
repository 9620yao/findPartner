$("#powerInfo").datagrid({
	url : 'power/list',
	fitColumns:true,
	//fit:true,
	pagination:true,
	singleSelect:true,
	columns:[[    
	          {field:'upid',title:'编号',width:50,align:'center'},
	          {field:'upuid',title:'用户',width:50,align:'center'},
	          {field:'upower',title:'权限',width:40,align:'center',
	        	 /* formatter: function(value,row,index){
	        		  return row.partner.gender;
	        	  }*/
	          }, 
	          {field:'updata',title:'权限时间',width:50,align:'center',
	        	  formatter: function(value,row,index){
	        		 // alert(JSON.stringify(row)); //JSON.stringify()
	        		  return row.updata;
	        	  }
	          },
	          {field:'power',title:'权限',width:70,align:'center',
	        	  formatter: function(value,row,index){
	        		  return '<a class="power" href="javascript:void(0)" onclick="openpower(\''+index+'\')">权限</a>'+
	        		  '<script>$(".power").linkbutton({iconCls:"icon-lock"});</script>';
	        	  }
	          }
	          ]]      
});

function openpower(index){
	var row = $("#dg").datagrid("getRows")[index];
	var faid = row.aid;
	$.post("power/sure",{"faid":faid},function(data){
		if(data){
			$.messager.alert('权限提示','该用户有封禁记录，您可以在权限管理查看和解封..');
			return false;
		}
		power(faid);
	},"json");
}

function power(faid){
	$.post("power/add",{"faid":faid},function(data){
		if(data){
			$.messager.alert('权限提示','封禁成功，您可以在权限管理查看..');
			return false;
		}
		$.messager.alert('权限提示','封禁失败，请您在确认后操作..');
	},"json");
}

