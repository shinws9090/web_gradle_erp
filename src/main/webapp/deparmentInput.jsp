<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>추가</h2>
<form action="DepartmentInsertServlet">
		<fieldset>
			<legend>부서정보</legend>
			<ul>
				<li>
					<label for="deptno">부서번호</label>
					<input type="text" name="deptno" size="20" id="deptno" autofocus required>
				</li>
				<li>
					<label for="deptname">부서이름</label>
					<input type="text" name="deptname" size="20" id="deptname">
				</li>
				<li>
					<label for="floor">부서위치</label>
					<input type="text" name="floor" size="20" id="floor">
				</li>
				<li>
					<input type="submit" value="추가"><input type="reset" value="취소"> 
				</li>
			</ul>
		</fieldset>
	</form>
	
</body>
</html>