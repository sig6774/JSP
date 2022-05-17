<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p>
		Scripting 표현식<br>
		<%= 10 * 4 %><br>
		<%= 55.55 + 3 %><br>
		<%= "안녕하세요!" %><br>
		<% int i = 1; %>
		<%= "i값은 : " + i %><br>
		
	</p>
	<hr>
	<p>
		EL 표현식 <br>
		${10*4}<br>
		${55.55 + 3}<br>
		${'안녕하세요!'}<br>
		${'값은 : ' + i}<br>
		
	</p>
	
	
</body>
</html>