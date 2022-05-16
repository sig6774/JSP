<%@page import="kr.com.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<% UserVO user = (UserVO) session.getAttribute("user");
		// Session 가져오기 
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 완료 세션 정보 <%=user %></h2>
	<h3><%= user.getUser_id() %></h3>
	<h3><%= user.getUser_name() %></h3>
	
</body>
</html>