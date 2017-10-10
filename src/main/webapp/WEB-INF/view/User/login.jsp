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
<title>软件测试技术案例</title> 
<base href="<%=basePath%>"/>
<link rel="stylesheet" type="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" type="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />

</head>
<body>
	<form name="formLogin" method="post" action="login">
		<table class="loginTable" align="center">
			<tbody>
				<tr>
					<td colspan="2" class="loginHeader">请输入登录信息：222</td>
				</tr>
				<tr>
					<td colspan="2">
						<div>
							<c:if test="${error != null }">
		   					 ${error}
		    		</c:if>
						</div>
					</td>
				</tr>
				<tr>
					<td class="loginLabel" align="right">用户名:</td>
					<td align="right"><input name="name" type="text" /></td>
				</tr>
				<tr>
					<td class="loginLabel" align="right">密码：</td>
					<td align="right"><input name="psw" type="password" /></td>
				</tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right"><br /> <input value="登录" type="submit" /></td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>