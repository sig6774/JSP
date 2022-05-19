<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		UserVO vo = new UserVO(
				request.getParameter("id"),
				request.getParameter("pw"),
				request.getParameter("name"),
				request.getParameter("email"),
				request.getParameter("address")
				);
		session.setAttribute("member", vo);
	%>
	
	<a href = "EL_object03.jsp">EL로 세션 내의 객체 값을 표현</a>
</body>
</html>