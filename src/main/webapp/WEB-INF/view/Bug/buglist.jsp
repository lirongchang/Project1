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
			<td>项目列表</td>
			<td><a href="to_addbug" target="_self">新增</a></td>
		</tr>
	</table>
	<table>
		<c:forEach items="${list}" var="bug" varStatus="bugs">
            
			<tr align="center">
				<td>${bugs.index+1}</td>
				<td>名称:${bug.bug_summary}</td>
				<td>描述:${bug.bug_description}</td>
				<td>系统${bug.bug_os}</td>
				<td>严重级别:${bug.pon_id}</td>
				<%-- <td>所属项目:${bug.pro_id}</td> --%>
				
				<td>
				<c:forEach items="${pros}" var="pro" varStatus="users">
					<%-- <td>提交人:${bug.reporter_id}</td> --%>
					<c:if test="${bug.pro_id==pro.pro_id}">
						<td>所属项目:${pro.pro_name}</td>
					</c:if>
				</c:forEach>
                </td>
				
				
				<td>缺陷状态${bug.bug_status}</td>
                <td>
				<c:forEach items="${users}" var="user" varStatus="users">
					<%-- <td>提交人:${bug.reporter_id}</td> --%>
					<c:if test="${bug.reporter_id==user.id}">
						<td>提交人:${user.name}</td>
					</c:if>
				</c:forEach>
                </td>


              <td>
				<c:forEach items="${users}" var="user" varStatus="users">
					<%-- <td>提交人:${bug.reporter_id}</td> --%>
					<c:if test="${bug.handler_id==user.id}">
						<td>处理人:${user.name}</td>
					</c:if>
				</c:forEach>
                </td>


		<%-- 		<td>处理人:${bug.handler_id}</td> --%>
				<td>评论:${bug.bug_comment}</td>
				<td>优先级:${bug.bug_priority}</td>
				<td>提交时间:${bug.submite_time}</td>
                 <td><a href ="deletebug?bug_id=${bug.bug_id}" >删除</a></td>
			     <td><a href ="to_updatebug?bug_id=${bug.bug_id}" >更新</a></td>

				<%-- 	<td>评论:${bug.bug_comment}</td>  
			<td>优先级:${bug.bug_priority}</td> --%>
			</tr>
	 
		</c:forEach>
	</table>
</body>
</html>