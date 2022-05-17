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
		# Scripting <br>
		# data1 : <%= session.getAttribute("data1") %><br>
		# data2 : <%= application.getAttribute("data2") %><br>
	</p>
	
	<hr>
	
	<p>
		# EL <br>
		# data1 : ${data1 }<br>
		# data2(application) : ${applicationScope.data2 }<br>
		# data2(session) : ${sessionScope.data2 }<br>
		<%-- EL은 내장객체에 동일한 이름을 알아서 찾아줌 --%>
		<%-- 특별히 명세하고 싶을 때 : 내장객체이름Scope.이름 --%>
	</p>
</body>
</html>