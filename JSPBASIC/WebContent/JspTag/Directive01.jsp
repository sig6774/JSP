<%@page import="java.text.SimpleDateFormat"%>
<%@ page import ="java.util.Date" %> 
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
	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년MM월dd일 a hh시 mm분 ss초");
	String dayInfo = sdf.format(date);
	//문자열로 된 날짜를 포맷형식으로 전달
%>

오늘은 <%=dayInfo %> 입니다.
</body>
</html>