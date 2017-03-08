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
		<sql:query var="rs" dataSource="${dataSource}">
		select * from t_movedatadict
	</sql:query>
	<script type="text/javascript">
			var host = 'localhost'
			//192.168.1.207
			//localhost
				$('#dg').datagrid({toolbar: '#toolbar'});
			<!--初始化表单-->
			$(function(){		
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
		function addDicReport() {
			$('#p').window('open', true);
		}
		
	</script>	
</head>
<body>
	<div style="margin-bottom:10px">
		<input id="url" class="easyui-textbox" data-options="prompt:'http://192.168.1.201:9001/gaeaapi/DataDictionaryInstance/Move'" style="width:50%;height:32px" value="http://192.168.1.201:9001/gaeaapi/DataDictionaryInstance/Move"><br/>
	</div>
	<div id ="toolbar">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true" onclick="addDicReport()">addDic报告</a>
	</div>
	 <div id="p" class="easyui" data-options="minimized:true,title:'BI',iconCls:'icon-tip'">
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