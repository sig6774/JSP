<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
		// 주소를 치고 강제로 들어오는 접근 차단
		if (session.getAttribute("user") == null ){ %>
<script>
				alert("로그인 한 회원만 접근이 가능 ");
				location.href = "user_login.jsp";
			</script>
<% } else{
			UserVO user = (UserVO) session.getAttribute("user");
			// Session 가져오기 
	%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="../include/header.jsp"%>
	<%-- 값을 불러오는 것  --%>

	<div align = "center">
		<h2>My page</h2>
		<hr>
		<p>
			<strong><%=  user.getUser_name() %>(<%= user.getUser_id() %>)님의 정보를 관리합니다.</strong>
		</p>
		<hr>
		<br>
		
		<p>
			<a href="user_change_pw.jsp">비밀번호 변경</a> &nbsp;
			<a href="user_update.jsp">회원정보 변경</a> &nbsp;
			<a href="user_delete.jsp">회원 탈퇴</a> 
		</p>
		
	</div>



	<%@ include file="../include/footer.jsp"%>


</body>
</html>

<% } %>