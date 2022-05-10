<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String title1 = request.getParameter("title1");
String name = request.getParameter("name");
String concept = request.getParameter("concept");
String birth = request.getParameter("birth");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>선택하신 앨범 정보</h2>
	<hr>
	<h3>당신이 선택하신 사람은 김용명이며 생일은 1978. 10. 2 입니다.</h3>
	<hr>
	<%
		if (title1.equals("1")) {
	%>
	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/m3moJifwVLQ"
		title="YouTube video player" frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
	<%
		} else if (title1.equals("2")) {
	%>

	<iframe width="560" height="315"
		src="https://www.youtube.com/embed/AuRs80djfto"
		title="YouTube video player" frameborder="0"
		allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
		allowfullscreen></iframe>
	<%
		}
	%>
</body>
</html>