<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="article-list table-common con">
	<%-- ${list } --%>
	<h2>직책목록</h2>
	<table>
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>직책</td>
				<td>직급상사</td>
				<td>급여</td>
				<td>부서</td>
				<td>입사일</td>
				<td>비고</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list }">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.empname}</td>
					<td>${emp.title.titleName}(${emp.title.titleNo})</td>
					<td>${emp.manager.empname}(${emp.manager.empno})</td>
					<td><fmt:formatNumber value="${emp.salary}" pattern="\ #,### 원"/></td>
					<td>${emp.dept.deptName}(${emp.dept.deptNo})</td>
					<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy-MM-dd"/></td>
					<td><a href="EmployeeGetServlet?empNo=${emp.empno}">수정</a>
					<a href="EmployeeDeleteServlet?empno=${emp.empno }">해고</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
		<tr>
		<td colspan="8">
			<a href="index.jsp?page=employeeInput.jsp">사원추가</a>
			 </td>
		</tr>
		</tfoot>
	</table>
</body>
</html>