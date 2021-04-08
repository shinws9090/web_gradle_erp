<%@ page import="web_gradle_erp.ds.JndiDS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String pagefile = (String)request.getAttribute("page");
if (pagefile == null) {
	pagefile = (String)request.getParameter("page");
	if (pagefile == null){
	pagefile = "start.jsp";
	}
}
%>
<c:set var="con" value="${JndiDS.getConnection()}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동 테스트</title>

<link rel="stylesheet" href="css/style.css">
</head>
<body class="article-list table-common con">
	<c:out value="${con }"></c:out>
	<br>
	<div class="a">
		<h3>ERP</h3>
		<ul>
			<li><a href="TitleServlet">직책관리</a></li>
			<li><a href="DepartmentServlet">부서관리</a></li>
			<li><a href="EmployeeServlet">사원갈리리리</a></li>
		</ul>
	</div>
	<jsp:include page='<%=pagefile%>' />
	
</body>
</html>