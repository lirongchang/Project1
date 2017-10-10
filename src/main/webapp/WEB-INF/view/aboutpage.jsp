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
<meta name="description" content="DMS缺陷管理系统" />
<meta name="keywords" content="software testing, SpringMVC,Testing" />

</head>
<body  >
	 <table>
        	<tr>
        		<td> 
        		<p><strong class="loginHeader">DMS缺陷管理系统</strong></p>
          		<p>涉及基于持续集成的项目开发与测试，包括项目开发、单元测试、集成测试、系统测试等内容。</p>
        			
        		</td>
        		<td>
        			 <img align="right" border="0" src="static/images/illo-about.png"/>
        		</td>
        	</tr>
        	<tr>
        		<td colspan = "2">
        			<br/>
        			<br/> 
          		<p>项目涉及到的技术包括 Spring MVC、JInit、DBUnit、Mockitto、CheckStyle、Jenkings等。</p>
        		</td>
        	</tr>
        	
        </table> </body>
          </html>