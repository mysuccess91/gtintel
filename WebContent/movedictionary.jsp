<%@ page language="java" contentType="text/html; charset=utf-8"
	import="java.util.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<sql:setDataSource driver="com.mysql.jdbc.Driver"
	user="root"
	password="root"
	url="jdbc:mysql://192.168.1.207:3306/autotest?charachterEndcoding=UTF-8&useSSL=true"
	var="dataSource"
	scope="page"
/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

	<% response.setHeader("refresh","10"); %>
	<title>字典服务</title>
	<script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="./jquery-easyui-1.4.5/jquery.min.js"></script>
	<script type="text/javascript" src="./jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
	<script type="text/javascript" src="./jquery-easyui-1.4.5/locale/easyui-lang-zh_CN.js"></script>
	<!-- 引入EasyUI的样式文件-->
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/themes/default/easyui.css" type="text/css"/>
	 <!-- 引入EasyUI的图标样式文件-->
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/themes/icon.css" type="text/css"/>
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/demo/demo.css" type="text/css"/>
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/themes/default/panel.css" type="text/css"/>
	<script type="text/javascript" src="./jquery-easyui-1.4.5/extenal/jquery.edatagrid.js"></script>
	<script type="text/javascript" src="./js/json2.js"></script>
	<script type="text/javascript">
		var host = '192.168.1.207';
	</script>
	<script type="text/javascript">
			//var host = 'localhost'
			//192.168.1.207
			//localhost
				$('#dg').datagrid({toolbar: '#toolbar'});
			<!--初始化表单-->
			$(function(){
				$('#dg').datagrid({
					url	:	"http://"+host+":8080/gtintelWS/rest/dataDic/getMoveDicList",
	
					saveUrl : '',
					updateUrl : '',
					destroyUrl : "",
					//title	:	'basic demo',
					iconCls	:	'icon-save',
					pagination	:	true,
					striped		:	true,
					showFooter	:	true,
					//pageNumber	:	1,
					//pagesize	:	'10',
					//pageList	:	[10,20,30],
					fit	:	true,
					//loading:none,
					nowrap	:	false,
					fitColumns : true,
					singleSelect : true,
					method: "get",
					columns : [[
								{
								    title : '用例编号',
								    field : 'caseId',
								    width : 100
								},
					            {
						            title : '编号',
						            field : 'id',
						            width : 100,
						            editor:'numberbox'
					            },
					            {
						            title : 'src编号',
						            field : 'srcId',
						            width : 100,
						            editor:'text'
					            },
					            {
						            title : 'target编号',
						            field : 'targetId',
						            width : 100,
						            editor:'text'
					            }
					            ]]
				});
			});
			
			<!--初始化window和datagrid-->
			$(document).ready(function(){
				$("#p").window({
					width:600,    
				    height:400,    
				    modal:true,
				    closed:true
				});
				$('#moveDataDic').datagrid({
					iconCls	:	'icon-save',
					pagination	:	true,
					striped		:	true,
					showFooter	:	true,
					fit	:	true,
					fitColumns:true,
					nowrap	:	false,
					fitColumns : true,
					singleSelect : true,
				});
			});			
	</script>
	<!-- 表单操作 -->
	<script type="text/javascript">
	//var host = 'localhost'
		//192.168.1.207
		//localhost
		var editIndex = undefined;
		function endEditing(){
			if (editIndex == undefined){
				return true
				}
			if ($('#dg').datagrid('validateRow', editIndex)){
				
				$('#dg').datagrid('endEdit', editIndex);
				editIndex = undefined;
				return true;
			} else {
				return false;
			}
		}
		function onClickRow(index){
			if (editIndex != index){
				if (endEditing()){
					$('#dg').datagrid('selectRow', index)
							.datagrid('beginEdit', index);
					editIndex = index;
				} else {
					$('#dg').datagrid('selectRow', editIndex);
				}
			}
		}
		function append(){
			if (endEditing()){
				$('#dg').datagrid('appendRow',{id:''});
				editIndex = $('#dg').datagrid('getRows').length-1;	
				$('#dg').datagrid('selectRow', editIndex)
						.datagrid('beginEdit', editIndex);	
				
			}
		}
		function removedit(){
			if (editIndex == undefined){return}
			$('#dg').datagrid('cancelEdit', editIndex)
					.datagrid('deleteRow', editIndex);
			editIndex = undefined;
		}
		function accept(){
			if (editIndex == undefined){return}
 			$('#dg').datagrid('acceptChanges');
			var index = $('#dg').datagrid('getSelected');
			var index = eval(index);		
			//alert(index.targetId);
			var id = parseInt(index.id);
			var srcId = index.srcId;
			var targetId = index.targetId;
			var postData ={
					"id" : id,
					"srcId" : srcId,
					"targetId" : targetId
				};
			$.ajax({
				url :	  'http://'+host+':8080/gtintelWS/rest/dataDic/addMoveDic',
				type:	  'post',
				dataType: 'json',
				contentType: "application/json",
				data : postData,
				success:  function(data){
					editIndex = undefined;
					$.messager.alert('消息',data.message);
					location.replace("http://"+host+":8080/gtintelWS/movedictionary.jsp");
				},
				error:function(e){
					console.log(e);
				}
			}); 
			
		}
		
		function edit(){
			var row = $('#dg').datagrid('getSelected');
			var index = $('#dg').datagrid('getRowIndex',row);
			$('#dg').datagrid('beginEdit', index);
			editIndex = index;
			//$('#dg').datagrid('beginEdit', rowNum.id);
			
		}
		
		//保存编辑
		function update(){
			
			//$('#dg').datagrid('endEdit',editIndex).datagrid('cancelEdit', editIndex);
			//editIndex = undefined; 
			
			
			if (editIndex != undefined){
				$('#dg').datagrid('endEdit', editIndex);
				var index = $('#dg').datagrid('getSelected');
				var index = eval(index);
				var id = index.id;
				var srcId = index.srcId;
				var targetId = index.targetId;
				var caseId = index.caseId;
				
				$.ajax({
					url :	  'http://'+host+':8080/gtintelWS/rest/dataDic/updateMoveDic',
					type:	  'post',
					dataType: 'json',
					data : {
						"id" : id,
						"srcId" : srcId,
						"targetId" : targetId,
						"caseId":caseId
					},
					success:  function(data){
						$.messager.alert('消息',data.message);
						editIndex = undefined
						location.replace("http://"+host+":8080/gtintelWS/movedictionary.jsp")
						//alert(data);
						
					}
				}); 
			}
			
			
		}
		function reject(){
			var row = $('#dg').datagrid('getSelected');
			var index = $('#dg').datagrid('getRowIndex',row);
			$('#dg').datagrid('cancelEdit', index);
		}
		
		function submit(){
			//$("#dg").datagrid('loading');
			var url = $('#url').textbox('getValue');
			$.ajax({
				url :	  'http://'+host+':8080/gtintelWS/rest/dataDic/getMoveDicReq',
				type:	  'get',
				dataType: 'text',
				data	:	"url="+url,
				success:  function(data){
					$.messager.alert('消息','submit succesful');
					location.replace("http://"+host+":8080/gtintelWS/movedictionary.jsp");
					
					//alert(data);
				},
				error : function(){
					$.messager.alert('警告','submit failed');
				}
				
			});
			
		}
		
		function report() {
			$('#p').window('open', true);
		}
		
	</script>	
</head>
<body>

	<div style="margin-bottom:10px">
		<input id="url" class="easyui-textbox" data-options="prompt:'http://192.168.1.201:9001/gaeaapi/DataDictionaryInstance/Move'" style="width:50%;height:32px" value="http://192.168.1.201:9001/gaeaapi/DataDictionaryInstance/Move"><br/>
	</div>
	
	<div id ="toolbar">
		<!-- <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="reload()">reload</a> -->
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="removedit()">取消添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存添加</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" onclick="edit()">编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="update()">保存编辑</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-undo',plain:true" onclick="reject()">取消编辑</a>
<!-- 		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="getChanges()">GetChanges</a> -->
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true" onclick="submit()">发送</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true" onclick="report()">查看报告</a>
	</div>
	<!-- 测试绑定 -->
	<table id="dg">
	</table> 
	<sql:query var="rs" dataSource="${dataSource}">
		select * from t_movedatadict
	</sql:query>
	
	 <div id="p" class="easyui" data-options="minimized:true,title:'BI',iconCls:'icon-tip'">
		<%--<table id="moveDataDic">
				<tr>
					<c:forEach var="columnName" items="${rs.columnNames}">
						<td>${columnName}</td>
					</c:forEach>
				</tr>
				
				<c:forEach var="row" items="${rs.rows }">
					<tr>
						<c:forEach var="columnName" items="${rs.columnNames}">
							<td>${row[columnName]}</td>
						</c:forEach>
					</tr>
				</c:forEach>
			</table> --%>
			
			<table id="moveDataDic">
			<thead>
				<tr>
					<c:forEach var="columnName" items="${rs.columnNames}">				
							<th field="${columnName}">${columnName}</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody> 
			<c:forEach var="row" items="${rs.rows}">
				<tr>
					<c:forEach var="columnName" items="${rs.columnNames}">
						<td>${row[columnName]}</td>
					</c:forEach>
				</tr> 
			</c:forEach>
			</tbody>                           
	</table>
	</div>
</body>
</html>