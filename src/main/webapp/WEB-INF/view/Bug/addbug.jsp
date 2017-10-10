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
	<form  method="post" action="addbug">
		<table class="loginTable" align="center">
			<tbody>
				<tr>
					<td colspan="2" class="loginHeader">请输入缺陷信息</td>
				</tr>
				<tr>
					<td class="loginLabel" align="right">缺陷主题</td>
					<td align="right"><input name="bug_summary" type="text" /></td>
				</tr>
				 
				<tr>
					<td class="loginLabel" align="right">缺陷系统</td>
					<td align="right"><input name="bug_os" type="text" /></td>
				</tr>
				<tr>
					  <td class="loginLabel" align="right">所属项目</td>
			  	      <td align="right"> 
			  <select  name="pro_id" >
				 <c:forEach items="${pros}" var="pro">
			               <option value=${pro.pro_id} >${pro.pro_name} </option>
					</c:forEach>
				</select> 
				</td> 
				</tr>
				
			 <tr>
					<td class="loginLabel" align="right">严重描述</td>
					<td align="right"><input name="bug_description" type="text" /></td>
				</tr>
				
				 <tr>
					<td class="loginLabel" align="right">严重优先级</td>
					<td align="right"><input name="bug_priority" type="text" /></td>
				</tr>
				
				 <tr>
					<td class="loginLabel" align="right">严重状态</td>
					<td align="right"><input name="bug_status" type="text" /></td>
				</tr>
				 
				<tr>
					<td class="loginLabel" align="right">严重级别</td>
					<td align="right"><input name="pon_id" type="text" /></td>
				</tr>
				<tr>
					  <td class="loginLabel" align="right">提交人</td>
			  	      <td align="right"> 
			      <select  name="reporter_id" >
				  
			       <option value=${user.id} >${user.name} </option>
			 
				</select>   
				
			<!-- 		<td align="right"><input name="reporter_id" type="text" /></td> -->
				</td> 
				</tr>
				
				<tr>
					<td class="loginLabel" align="right">处理人</td>
					<td align="right"><input name="handler_id" type="text" /></td>
				</tr>
				
				 <tr>
					<td class="loginLabel" align="right">严重评论</td>
					<td align="right"><input name="bug_comment" type="text" /></td>
				</tr>
				
				
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right"><br /> <input value="提交" type="submit" /></td>
				</tr>
			</tbody>     
		</table>
	</form>
</body>
</html>