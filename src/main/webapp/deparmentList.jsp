<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- ${list } --%>
	<h2>직책목록</h2>
	<table border="1">
		<thead>
			<tr>
				<td>부서번호</td>
				<td>부서명</td>
				<td>위치</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dept" items="${list }">
				<tr>
					<td><a href="DepartmentGetServlet?deptNo=${dept.deptNo}">${dept.deptNo}</a></td>
					<td><a href="DepartmentGetServlet?deptNo=${dept.deptNo}">${dept.deptName}</a></td>
					<td><a href="DepartmentGetServlet?deptNo=${dept.deptNo}">${dept.floor}</a></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
		<tr>
		<td colspan="3">
			<a href="index.jsp?page=deparmentInput.jsp">부서추가</a>
			 </td>
		</tr>
		</tfoot>
	</table>
</body>
</html>