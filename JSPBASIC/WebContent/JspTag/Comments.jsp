<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comments</title>
</head>
<body>

<%
	// Scriptlet 내부에서 자바 주석을 사용 가능
	
	/*
	여러줄 주석도 가눙~
	*/
%>

<!-- 요것은 HTML 주석으로 이것도 당연히 가능  -->
	여기는 주석 아님!<br>
	<hr>
	<%-- 이거는 jsp 주석이예용! 
	다른 주석은 페이지 소스에서 보이는데 jsp 주석은 페이지 소스에서 보이지 않음--%>
	여기도 주석은 아니예용!

</body>
</html>