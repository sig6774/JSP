<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="req_bmi.jsp"> 
	<!-- action에 데이터를 전달받을 페이지 작성 -->
		키: <input type="text" name="cm" value=""> <br>
		몸무게: <input type="password" name="kg" required> <br> #
		성별 <br> <input type="radio" name="gender" value="male"> 남
		<input type="radio" name="gender" value="female"> 여 <br>

		
		<input type="submit" value = "제출">
		</form>
</body>
</html>