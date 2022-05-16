<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<%
		int num = Integer.parseInt(request.getParameter("bID"));
		// list.jsp에서 받아온 아이디 
		
		BoardDAO dao = BoardDAO.getInstance();
		boolean flag = dao.delete(num);
	%>

	<%
		if (flag){
	%>
	<h2> 삭제가 완료되었습니다.</h2>
	<a href = "write.jsp">글 작성 이동</a>
	
	<%} else { %>
	<h2> 삭제가 완료되지 못했습니다.</h2>
	<a href = "list.jsp">글 목록 이동</a>
	<%} %>
