<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	String title = request.getParameter("title");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		if (title.equals("sel1")) {
	%>
	<div align="center">
		<h2>선택하신 앨범 정보</h2>
		<hr>
		<p>
			당신이 선택하신 앨범은 싸이의 <strong>THAT THAT</strong>입니다.
		</p>
		<hr>

		<h3>타이틀 곡 뮤직 비디오</h3>
		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/8dJyRm2jJ-U?autoplay=1"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>
	</div>
	<%
		} else if (title.equals("sel2")) {
	%>

	<div align="center">
		<h2>선택하신 앨범 정보</h2>
		<hr>
		<p>
			당신이 선택하신 앨범은 빅뱅의 <strong>봄여름가을겨울 (Still life)</strong>입니다.
		</p>
		<hr>

		<h3>타이틀 곡 뮤직 비디오</h3>
		<iframe width="560" height="315"
			src="https://www.youtube.com/embed/eN5mG_yMDiM?autoplay=1"
			title="YouTube video player" frameborder="0"
			allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
			allowfullscreen></iframe>
	</div>
	<%
		}
	%>
</body>
</html>