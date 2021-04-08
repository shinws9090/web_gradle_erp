<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>타이틀틀</title>
</head>
<body>
<%-- ${title} --%>
<form action="EmployeeUpdateServlet">
		<fieldset>
			<legend>부서정보</legend>
			<table>
			<tr> 
				<td>
					<label for="empno">사원번호 : </label>
				</td>
				<td>
					<label for="empno">${Employee.empno }</label>
					<input type="hidden" name="empno" size="20" id="empno" value="${Employee.empno }" required checked="checked">
				</td>
			</tr>
			<tr>
				<td>
					<label for="empname">사원명</label>
				</td>
				<td>
					
					<input type="text" name="empname" size="20" id="empname" value="${Employee.empname }">
				</td>
			</tr>
			<tr>
				<td>
					<label for="title">직책</label>
					
				</td>
				<td>
					<select name="title"  >
					<c:forEach var="t" items="${titleList}">
						<c:choose >
						<c:when test='${Employee.title.titleNo == t.titleNo }'>
						<option value="${t.titleNo}" selected>${t.titleName}</option>
						</c:when>
						<c:otherwise>
						<option value="${t.titleNo}" >${t.titleName}</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label for="manager">직급상사</label>
					
				</td>
				<td>
					<select name="manager"  >
					<c:forEach var="m" items="${managerList}">
						<c:choose>
						<c:when test='${Employee.manager.empno == m.empno }'>
						<option value="${m.empno}" selected>${m.empname}</option>
						</c:when>
						<c:otherwise>
						<option value="${m.empno}" >${m.empname}</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label for="salary">급여</label>
				</td>
				<td>
					<input type="number" name="salary" size="20" id="salary" value="${Employee.salary }">
				</td>
			</tr>
			<tr>
				<td>
					<label for="dept">부서</label>
					</td>
				<td>
					<select name="dept"  >
					<c:forEach var="d" items="${deptList}">
						<c:choose>
						<c:when test="${Employee.dept.deptNo == d.deptNo }">
						<option value="${d.deptNo}" selected>${d.deptName}</option>
						</c:when>
						<c:otherwise>
						<option value="${d.deptNo}" >${d.deptName}</option>
						</c:otherwise>
						</c:choose>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					<label for="hireDate">입사일</label>
				</td>
				<td>
					<input type="date" name="hireDate" size="20" id="hireDate" value="<fmt:formatDate value="${Employee.hireDate}" pattern="yyyy-MM-dd"/>">
				</td>
			</tr>
			<tr>
				<td>
					<button>저장</button>
				</td>
			</tr>
			</table>
		</fieldset>
					</form>

</body>
</html>