<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


	<%
		/*
		 user_delete.jsp에서 보낸 check_pw를 통해 유효성 검사를 진행 
		 진행하여 유효성을 만족한다면 세션에서 id를 가져와서 삭제 
		 삭제가 완료되었으면 세션을 삭제(로그인 유지 없앰)
		 이후 메인 페이지로 이동
		*/
	%>