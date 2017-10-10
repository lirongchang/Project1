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
<title>DMS缺陷管理系统</title>
<base href="<%=basePath%>" />
<link rel="stylesheet" user="text/css" href="static/css/sm-default.css" />
<link rel="stylesheet" user="text/css" href="static/css/styles.css" />
<meta name="description" content="软件测试技术案例" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />

</head>
<body>
	<table width="100%">
		<tr>
			<td>缺陷附件列表</td>
			<td><a href="to_addfile" target="_self">新增</a></td>
		</tr>
	</table>
	<table>
		<c:forEach items="${list}" var="file" varStatus="files">
			<tr align="center">
				<td>${files.index+1}</td>
				<td>名称:${file.file_name}</td>
				<td>bug_id:${file.bug_id}</td>
				<td>user_id:${file.user_id}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>