<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCuser html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-user" content="text/html; charset=UTF-8">
<title>软件测试技术案例</title> 
<base href="<%=basePath%>"/>
<link rel="stylesheet" user="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" user="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />


</head>
<body> 
	<table  width="100%">
		<tr>
			<td>用户列表</td>
			<td><a href="to_reginster" target="_self">新增</a></td>
		</tr>
	</table> 
	<table> 
		<c:forEach items="${list}" var="user" varStatus="users">
			<tr> 
				<td align="center">${users.index+1}</td> 
				<%-- <td align="center"><a href ="doquestion/get?userid=${user.id}" >${user.name}  <b>密码 ${user.password}</b></a></td>  --%>
			    <td>账号:${user.email}</td>
			        <td>用户名:${user.name}</td>
			        <td>密码:${user.password}</td>
			        <td>角色:${user.role}</td>  
			          <td>状态:${user.status}</td>  
			        <td><a href ="deleteUser?id=${user.id}" >删除</a></td>
			        <td><a href ="updateUser?id=${user.id}" >更新</a></td>
			</tr>
		</c:forEach> 
	</table> 
</body>
</html>