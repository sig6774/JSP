<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		// 쿠기 생성 방법 
		// 1. 쿠키 객체를 생성 - 생성자의 매개값으로 쿠키의 이름과 저장할 데이터를 입력(String만 유효)
		String id = "abc1234";
	
		Cookie idCoo = new Cookie("id_cookie", id);
		Cookie nameCoo = new Cookie("name_cookie", "홍길동");
		// 임포트 없이 알아서 사용 가능
		// 쿠키는 생성자에  이름과매개값을 지정해야함
		
		// 2. 쿠키 클래스의 setter 메서드로 쿠키의 속성을 설정
		nameCoo.setMaxAge(60*60);
		idCoo.setMaxAge(30);
		// 쿠키를 유지할 시간 설정(초단위) 
		/*
		setPath(): 쿠키 디렉토리 설정 (필수)
		setValue() : 쿠키 값 설정 
		setMaxAge() 쿠키 유효시간 설정
		
		getName() : 쿠키 이름을 얻음 
		getValue() : 쿠키 값을 얻음 
		*/
		
		// 3. http 응답 시 response 객체에 생성된 쿠키를 탑재하여 클라이언트로 전송
		response.addCookie(nameCoo);
		response.addCookie(idCoo);
		
		// 내가 요청을 하면 서버가 화면에 표시하는게 응답
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="cookie_check.jsp">쿠키 확인</a>
</body>
</html>