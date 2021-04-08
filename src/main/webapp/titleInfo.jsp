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
<form action="TitleUpdateServlet">
		<fieldset>
			<legend>직책정보</legend>
			<ul>
			
				<li>
					<label for="tno">직책번호 : </label>
					<label for="tno">${title.no }</label>
					<input type="hidden" name="tno" size="20" id="tno" value="${title.no }" required>
				</li>
				<li>
					<label for="tname">직책이름</label>
					<input type="text" name="tname" size="20" id="tname" value="${title.name }">
				<li>
					<input type="submit" value="수정">
				<%--<a href="titleUpdate.jsp?no=${title.no}&name=${title.name}">직책수정</a> --%>
				</li>
				<li>
					<a href="TitleDeleteServlet?tno=${title.no }">직책삭제</a>
				</li>
			</ul>
		</fieldset>
					</form>

</body>
</html>