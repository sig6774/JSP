<%@page import="kr.co.pr.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		String checkpw = request.getParameter("CHECKPW");
		boolean flag = UserDAO.getInstance().deleteUser(checkpw);
		System.out.println(checkpw);
		
		if (flag){ %>
		
		<script>
			alert('삭제 완료');
			location.href = 'user_login.jsp';
		</script>
			
			
		<%} else{ %>
		<script>
			alert('비밀번호가 틀립니다. 다시 한번 확인해주세요.');
			location.href = 'user_mypage.jsp';
		</script>
			
		<% }
	%>