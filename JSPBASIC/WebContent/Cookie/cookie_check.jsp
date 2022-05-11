<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
		// 클라이언트 쪽에서 전송된 쿠키를 가져오는 방법 
		Cookie[] cookies = request.getCookies();
		// 쿠키를 모두 줌 (return Cookie [])
		
		boolean flag = false; 
		// 쿠키 존재 유무 파악 변수
		// 쿠키가 있다면 true로 반환될 예정
		
		if (cookies != null){
			for (Cookie c : cookies){
				if(c.getName().equals("id_cookie")){
					// getName() : 쿠키 이름을 가져오는 메서드
					out.print("<h3> 아이디 쿠키가 존재합니다! </h3>");
					String value = c.getValue(); 
					// getValue() : 쿠기 내부 값을 얻어오는 메서드
					out.print("쿠키의 값 : " +value);
					flag = true;
					break;
				}
			}
			if (!flag){
				out.print("<h3> 찾으시는 쿠키가 없습니다. </h3>");
			}
		}
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "cookie_check_all.jsp">모든 쿠키 확인</a>
</body>
</html>