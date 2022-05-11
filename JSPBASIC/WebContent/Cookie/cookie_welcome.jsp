<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%	
		Cookie[] cookies = request.getCookies();
		String userID = null;
		if (cookies != null) {
			for (Cookie c : cookies){
				if (c.getName().equals("login_cookie")){
					// 로그인을 성공했을때만 부여되는 쿠키 
					userID = c.getValue();
					break;
				}
			}
		}
		// userID에 null 이거나 사용자의 id가 들어가있음 
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (userID != null){  // 아직 로그인 중%>
			<p>
			<%=userID %>님 환영합니다! <br>
			 <a href = "cookie_login.jsp">로그인 화면으로</a> 
			</p>
			
		
		<% } else { // 로그인을 안했거나 로그인 시간이 끝나 특정 쿠키가 없을 때 %>
			<p>
			시간이 지나 자동 로그아웃 처리되었습니다<br>
			<a href = "cookie_login.jsp">로그인 화면으로</a>
			</p>
			
	<% }%>
</body>
</html>