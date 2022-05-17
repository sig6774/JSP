<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


	<%
		String name = request.getParameter("name");
		String nick = request.getParameter("nick");
	%> 
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<p>
		# Scripting<br>
		# 이름 : <%= name %> <br>
		# 별명 : <%= nick %> <br>
	</p> 
<hr>
	
	<%-- 
		EL에서 데이터를 참조할 때 영역을 명시하지 않는다면 
		page -> request -> session -> application
		순서대로 검색하여 찾아내서 표현 
		
	 --%>
	<p>
		# EL(Expression Language)<br>
		# 이름 : ${param.name}<br>
		# 별명 : ${param.nick}<br> 
	</p>
	
	<%
		session.setAttribute("data1", "hello");
		application.setAttribute("data2", "bye~");
		session.setAttribute("data2", "이름은 같지만 다른 데이터");
		
	%>
	
	<a href = "EL_result.jsp">세션,어플리케이션 데이터를 화면에 출력</a>

</body>
</html>