<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		/*
		- 세션에 저장한 데이터는 브라우저 창이 종료될 때 까지 혹은 세션의 유효시간이 
		만료되기 전까지 웹 어플리케이션의 모든 jsp파일에서 사용 가능
		
		- 세션에 저장된 데이터를 가져오려면 session 객체의 메서드 getAttribute()를 사용하며
		매개값으로 가져올 세션 데이터의 이름을 작성
		*/
		String nick = (String) session.getAttribute("nickname");
		// getAttribute의 리턴 타입은 Object이기 때문에 강제 형 변환을 통해 타입을 내려서 준비한 변수에 대입
		String[] hobbies = (String []) session.getAttribute("hobbies");
		
		out.print(nick+ "<br>");
		out.print(Arrays.toString(hobbies) + "<br>");
		out.print("-----------------------------<br>" );
		
		// 세션의 유효기간 설정.
		// 세션의 수명을 따로 지정하지 않으면 기본 30분의 유효시간을 가짐
		session.setMaxInactiveInterval(10*2); // 20초 짜리 세션
		
		int sTime = session.getMaxInactiveInterval();
		// 현재 세션의 유효시간을 확인 
		out.print("세션의 유효시간 : " + sTime + "초 <br>");
		out.print("--------------------------------- <br> ");
		
	 	// 특정 세션의 데이터를 삭제(지우고 싶은 세션 이름) 
	 	session.removeAttribute("nickname");
		
	 	nick = (String) session.getAttribute("nickname");
	 	out.print("삭제 후 nick의 값 : " + nick + "<br>");
		out.print("--------------------------------- <br> ");
		
		// 모든 세션 데이터를 삭제 (무효화 메소드)
		session.invalidate();
		hobbies = (String []) session.getAttribute("hobbies");
		// 세션이 무효화되었으므로 (해당 페이지에서 더 이상 세션 객체를 사용할 수 없으므로) getAttribute()를 사용할 수 없음
		// 아래의 코드는 에러가 발생 
		// 새롭게 요청이 들어오기 전까지는 세션 객체를 사용할 수 없음
		
		out.print("삭제 후 hobbies의 값 : " + Arrays.toString(hobbies) + "<br>");
		out.print("-----------------------------<br>" );
		
		
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>