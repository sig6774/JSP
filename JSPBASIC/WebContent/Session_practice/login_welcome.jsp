<%@page import="user.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		User u = (User) session.getAttribute("login");
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> <%= u.getName() %>님 로그인을 환영합니다!</h2>
<h3> 당신의 닉네임은 <%= u.getNickName() %>입니다.</h3>

</body>
</html>