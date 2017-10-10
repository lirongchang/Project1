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
<title>缺陷管理系统</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" type="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" type="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />
</head>
<body>
	<table align="center" class="canvas" border="0" cellpadding="0"
		cellspacing="0" width="857">
		<tbody>
			<div align="center  class="subNavback" >
				<img src="static/images/subNav.png" alt="缺陷管理系统"
					style="position: absolute;" />
				<div   class="subNav"  >
					<ul>
						<li class="vertRule"><a href="bug" target="mainframe">缺陷</a></li>
						<li class="vertRule"><a href="project" target="mainframe">项目</a></li>
						</li>
						<li class="vertRule"><a href="to_login" target="mainframe">管理员登录</a></li>
						<li class="vertRule"><a href="about" target="mainframe">退出</a></li>
						<li class="vertRule"><a href="to_reginster"
							target="mainframe">注册</a></li>
						<li><a href=about target="mainframe">关于</a></li>
					</ul>
		 
				</div>
			</div>

			<div>
				<iframe frameborder=0 width=1400 height=1000 marginheight=0
					marginwidth=0 scrolling=no name="mainframe" src="about"></iframe>
			</div>
		</tbody>
	</table>
</body>
</html>
