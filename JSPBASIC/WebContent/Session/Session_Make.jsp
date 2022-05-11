<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%-- 
		- 세션은 쿠키와 마찬가지로 http 통신 데이터를 유지하기 위한 수단으로 사용 
		- 세션에 데이터를 저장할 때는 jsp 내장 객체 session이 지원하는 
		  setAttribute() 메서드를 사용 
		- 해당 메서드의 첫번째 매개값으로 세션의 이름을 정하고, 두번째로 세션에 저장할 값을 지정
		 --%>
		 
		 <%
		 	session.setAttribute("nickname", "홍길동");
		 	session.setAttribute("hobbies", new String[] {"축구", "독서", "게임"});
		 	// session의 setAttribute에서 value는 Object로 지정되어 있으므로 모든 객체 대입 가능

		 %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="session_check.jsp">세션 데이터 확인</a>
</body>
</html>