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
<title>字典服务</title>
	<script type="text/javascript" src="./js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="./jquery-easyui-1.4.5/jquery.min.js"></script>
	<script type="text/javascript" src="./jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
	<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
	<script type="text/javascript" src="./jquery-easyui-1.4.5/locale/easyui-lang-cz.js"></script>
	<!-- 引入EasyUI的样式文件-->
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/themes/default/easyui.css" type="text/css"/>
	 <!-- 引入EasyUI的图标样式文件-->
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/themes/icon.css" type="text/css"/>
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/demo/demo.css" type="text/css"/>
	<link rel="stylesheet" href="./jquery-easyui-1.4.5/themes/default/panel.css" type="text/css"/>
<script type="text/javascript" src="./jquery-easyui-1.4.5/extenal/jquery.edatagrid.js"></script>

<!-- 表单脚本 -->
<script type="text/javascript">
		var host = 'localhost'
		//192.168.1.207
		//localhost
		$(function(){
			$('#dg').datagrid({
				url	:	"http://"+host+":8080/gtintelWS/rest/dataDic/getMoveDicList",
					//'http://localhost:8080/gtintelWS/rest/dataDic/getMoveDicList',
					//'http://localhost:8080/gtintelWS/datagrid.json',
				saveUrl : '',
				updateUrl : '',
				destroyUrl : '',
				//title	:	'basic demo',
				iconCls	:	'icon-save',
				pagimation	:	true,
				pagesize	:	'10',
				pageList	:	[10,20,30],
				fit	:	true,
				nowrap	:	false,
				fitColumns : false,
				method: "get",
				columns : [[
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
				            },
				            {
					            title : '返回',
					            field : 'response',
					            width : 100,
					            editor:'text'
				            },
				            {
					            title : '结果',
					            field : 'isPassed',
					            width : 100,
					            editor:'text'
				            }
				            ]]
			});
		});
</script>

<script type="text/javascript">
	var host = 'localhost'
		//192.168.1.207
		//localhost
	
	function submit(){
		
		$.ajax({
			url :	  'http://'+host+':8080/gtintelWS/rest/dataDic/getMoveDicReq',
			type:	  'get',
			dataType: 'text',
			success:  function(data){
				location.replace("http://"+host+":8080/gtintelWS/movedictionary.jsp");
				
				alert(data);
			}
			
		});
		
	}
	
/* 	function reload() {
		$.ajax({
			url :	  'http://'+host+':8080/gtintelWS/rest/dataDic/getMoveDicList',
			type:	  'get',
			success:	function(data){
				var obj = eval(data);
				//var obj = eval("("+data+")");
				//测试通过
				var tbody=$('<tbody></tbody>');
				
 				$(obj).each(function(index){
					var val = obj[index];
					var tr = $('<tr></tr>');
					//alert(val.id);
					tr.append('<td>'+val.id+'</td>'+'<td>'+val.srcId+'</td>'+'<td>'+val.targetId+'</td>');
					$('td').setAttribute('width','20px');
					tbody.append(tr);
				}); 
				$('#moveDataDic tbody').replaceWith(tbody); 
				//直接loadData绑定本地数据
				
				
				$('#tt').datagrid('loadData', a);
			}
		});
	} */
</script>
</head>
<body>
	<sql:query var="rs" dataSource="${dataSource}">
		select * from t_movedatadict
	</sql:query>
		<div style="margin-bottom:10px">
			<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="reload()">reload</a>
		</div>
<%-- 	<table id="moveDataDic" class="easyui-datagrid" >
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
	</table> --%>
	
	<br>
	<!-- 测试绑定 -->
	<table id="dg">
	</table>
	
	<!-- 测试 -->
<%-- 	<jsp:useBean id="moveDataDicReq" class="gtintel.entity.MoveDataDicReq">
		<jsp:setProperty name="moveDataDicReq" property="id" value="3"/>
		<jsp:setProperty name="moveDataDicReq" property="srcId" value="3"/>
		<jsp:setProperty name="moveDataDicReq" property="targetId" value="3"/>
	</jsp:useBean>
	<p>
		id:<jsp:getProperty property="id" name="moveDataDicReq"/>
		srcId:<jsp:getProperty property="srcId" name="moveDataDicReq"/>
		targetId:<jsp:getProperty property="targetId" name="moveDataDicReq"/>
	</p> --%>
	
	<input id="btn_submit" type="button" value="发送数据" style="height:20px;width:100px;"   onclick="submit()"/>
</body>
</html>