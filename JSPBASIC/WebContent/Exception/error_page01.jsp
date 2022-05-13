<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ page errorPage="error_page02.jsp"%>
<% // 에러 페이지를  import  %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%= request.getParameter("id").toLowerCase() 
		// id를 지정하지 않았으므로 null이 오고 null.toLowerCase()가 오기 때문에 
		// 에러 발생
	%>

</body>
</html>