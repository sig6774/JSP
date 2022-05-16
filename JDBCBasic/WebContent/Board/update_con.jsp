<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
    	request.setCharacterEncoding("utf-8");
	
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// 값을 받아옴 
		
		BoardVO upBoard = new BoardVO();
		upBoard.setWriter(writer);
		upBoard.setTitle(title);
		upBoard.setContent(content);
		// 받아온 값을 새로운 BoardVO 객체에 넣어줌
		
		BoardDAO dao = BoardDAO.getInstance();
		// 주소값을 받아옴 
		boolean flag = dao.update(upBoard);
		
		if (flag) {
			response.sendRedirect("board_update_success.jsp");
		}
		else {
			response.sendRedirect("update.jsp");
		}
	%>
		