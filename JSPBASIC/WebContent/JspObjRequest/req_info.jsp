<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>req_info</title>
</head>
<body>
	<%--
	request는 브라우저에 대한 정보, 사용자가 전달하는 값에 대한 많은 정보가 있음 
	(요청에 대한 전반적인 정보) 
	request객체는 내장 객체이며 직접 생성하지 않아도 
	요청이 들어올때 자동으로 객체가 생성되기 때문에 
	바로 사용 가능
	--%>
	
	URL 주소 : <%= request.getRequestURL() %> <br>
	URI 주소 : <%= request.getRequestURI() %> <br>
	컨텐스트 루트 : <%= request.getContextPath() %> <br>
	서버이름 : <%= request.getServerName() %><br>
	포트 번호 : <%= request.getServerPort() %> <br>
	IP주소 : <%= request.getRemoteAddr() %>


</body>
</html>