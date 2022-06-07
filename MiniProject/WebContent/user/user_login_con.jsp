<%@page import="kr.co.pr.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		System.out.println(id + pw);
		boolean flag = UserDAO.getInstance().loginUser(id, pw);
		System.out.println(flag);
		if (flag){ 
			session.setAttribute("userInfo", UserDAO.getInstance().userInfo(id, pw));
			// 로그인을 성공하면 로그인 정보를 가져옴
			response.sendRedirect("user_mypage.jsp");
			// 세션의 정보를 특정 위치로 보냄
		%>
			<script>
				alert("로그인 성공");
				location.href = "user_mypage.jsp";
			</script>
		<% }
		else{ %>
			<script>
				alert("로그인 실패 다시 로그인 해주세요");
				history.back();
			</script>
		<%}
	%>
