<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- ${title} --%>
<form action="DepartmentUpdateServlet">
		<fieldset>
			<legend>부서정보</legend>
			<ul>
			
				<li>
					<label for="deptno">부서번호 : </label>
					<label for="deptno">${Department.deptNo }</label>
					<input type="hidden" name="deptno" size="20" id="deptno" value="${Department.deptNo }" required>
				</li>
				<li>
					<label for="deptname">부서명</label>
					<input type="text" name="deptname" size="20" id="deptname" value="${Department.deptName }">
				</li>
				<li>
					<label for="floor">위치</label>
					<input type="text" name="floor" size="20" id="floor" value="${Department.floor }">
				</li>
				<li>
					
					<input type="submit" value="수정">
				<%--<a href="titleUpdate.jsp?no=${title.no}&name=${title.name}">직책수정</a> --%>
				</li>
				<li>
					<a href="DepartmentDeleteServlet?deptNo=${Department.deptNo }">부서삭제</a>
				</li>
			</ul>
		</fieldset>
					</form>

</body>
</html>