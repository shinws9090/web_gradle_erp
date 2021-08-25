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
	  <label for="menu-button" class="menu-button--label">▤</label>

    <!--    Checkbox state controls the menu position. When it is checked the menu slides in-->
    <input type="checkbox" id="menu-button">
	<div class="menu-wrap">
        <div class="side-menu">
		<h3>ERP</h3>
		 <ul class="side-menu--list">
			<li><a class="subset">직책관리</a><a href="TitleServlet">직책리스트</a></li>
			<li><a class="subset">부서관리</a><a href="DepartmentServlet">부서리스트</a></li>
			<li><a class="subset">사원갈리리리</a><a href="EmployeeServlet">사원리스트</a></li>
		</ul>
	</div>
	</div>
	<jsp:include page='<%=pagefile%>' />
	
</body>
</html>