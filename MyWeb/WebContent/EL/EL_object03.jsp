<%@page import="kr.com.jsp.user.model.UserVO"%>
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
		UserVO vo = (UserVO) session.getAttribute("member");
		// member라는 이름의 UserVO객체를 가져옴
	%>
	
	<p>
		# 이름 : <%= vo.getUser_name() %> <br>
		# 아이디 : <%= vo.getUser_id() %> <br>
		# 이메일 : <%= vo.getUser_email() %> <br>
		# 주소 : <%= vo.getUser_address() %>
	</p>
	
	<hr>
	
	<p>
		# 이름 : ${sessionScope.member.user_name} <br>
		# 아이디 : ${member.user_id }<br>
		# 이메일 : ${member.user_email }<br>
		# 주소 : ${member.user_address }<br>
		
		<%-- getname이 아니고 user_name을 써야함	  
		--%>
	</p>
</body>
</html>