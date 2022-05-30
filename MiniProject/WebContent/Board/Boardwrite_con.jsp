<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	String writer = request.getParameter("Bwriter");
    	String title = request.getParameter("Btitle");
    	String content = request.getParameter("Bcontent");
    	
    	System.out.println(title);
    	// 값을 board_write.jsp에서 받아오는 것을 확인
   
    	BoardDAO.getInstance().regist(title, writer, content);
    	System.out.println("등록완료");
    	response.sendRedirect("Boardlist.jsp");
    	
    %>