<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>DMS缺陷管理系统</title> 
<base href="<%=basePath%>"/>
<link rel="stylesheet" type="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" type="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />

</head>
<body>
	<form  action="addfile" method="post" enctype="multipart/form-data" >
		<table class="loginTable" align="center">
			<tbody>
				<tr>
					<td colspan="2" class="loginHeader">请输入项目信息</td>
				</tr>
				<tr>
					<td class="loginLabel" align="right">附件名称</td>
					<td align="right"><input name="file_name" type="text" /></td>
				</tr>
				 
				<tr>
					<td class="loginLabel" align="right">缺陷id</td>
					<td align="right"><input name="bug_id" type="text" /></td>
				</tr>
				 <tr>
					<td class="loginLabel" align="right">提交人</td>
					<td align="right"><input name="user_id" type="text" /></td>
				</tr>
				
				<tr>
					<td class="loginLabel" align="right">附件</td>
					<td align="right"><input name="file" type="file"  /></td>
				</tr>
				
				
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right"><br /> <input value="注册" type="submit" /></td>
				</tr>
			</tbody>     
		</table>
	</form>
</body>
</html>