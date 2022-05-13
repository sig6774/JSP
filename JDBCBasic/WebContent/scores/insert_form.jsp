<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert form</title>
</head>
<body>
		<h1>시험점수 등록하기 </h1>
		<form action="insert_controller.jsp" method = "post">
		<!-- form안의 데이터를 POST형식으로  insert_controller에 보냄  -->
		<p>
		# 이름 : <input type = "text" name = "name" maxlength = "6"> <br>
		# 국어점수 : <input type = "text" name = "kor" maxlength = "3"><br>
		# 영어점수 : <input type = "text" name = "eng" maxlength = "3"><br>
		# 수학점수 : <input type = "text" name = "math" maxlength = "3"><br>
		<input type = "submit" value = "확인">
		</p>
		
		
		</form>
</body>
</html>