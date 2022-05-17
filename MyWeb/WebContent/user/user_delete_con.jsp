<%@page import="kr.com.jsp.user.model.UserVO"%>
<%@page import="kr.com.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%
		/*
		 user_delete.jsp에서 보낸 check_pw를 통해 유효성 검사를 진행 
		 진행하여 유효성을 만족한다면 세션에서 id를 가져와서 삭제 
		 삭제가 완료되었으면 세션을 삭제(로그인 유지 없앰)
		 이후 메인 페이지로 이동
		*/
	%>
	<%
		request.setCharacterEncoding("utf-8");
		String checkPw = request.getParameter("check_pw");
		
		UserDAO dao = UserDAO.getInstance();
		// 주소값 가지고 오기 
		
		// sessio가지고 오기 
		UserVO user = (UserVO) session.getAttribute("user");
		
		int check = dao.userCheck(user.getUser_id(), checkPw);
		// id와 pw를 통해 유효성 검사
		
		if (check == 1) { 
			// pw가 같다면 
			
			dao.deleteUser(user.getUser_id());
			// 삭제 연산 진행 
			
			session.invalidate(); 
			// 세션 정보 삭제 
			%>
			<script>
				alert("삭제가 완료되었습니다.");
				location.href="/MyWeb";
				<%--  프로젝트 자체에 요청을 보내 welcomefilelist로 등록된 곳인 index.jsp로 보냄--%>
			</script>
		<% }
		else {
			// pw가 같지 않다면 
	%>	
	
			<script>
				alert("삭제가 완료되지 않았습니다. 비밀번호를 확인하세요.");
				history.back();
			</script>
	<% } %>
	