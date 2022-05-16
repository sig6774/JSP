<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    /*
    1. 사용자의 입력값을 가져오세요. 그리고 객체로 포장하세요.
    2. DAO클래스의 주소값을 받아 DB에 내용을 삽입하는 메서드를 호출하세요.
    (board_id -> 시퀀스 객체로 삽입, 날짜는 넣어줄 필요가 없다.)
    3. 글 등록 성공 시 list.jsp로 리다이렉팅,
    4. 글 등록 실패 시 write.jsp로 리다이렉팅 해 주세요.
    */
    
    request.setCharacterEncoding("utf-8");
	// post방식이므로 인코딩설정 
	
	String name = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	// write.jsp에서 준 값을 get 
	
	BoardVO board = new BoardVO();
	board.setWriter(name);
	board.setTitle(title);
	board.setContent(content);
	// 개별 값을 넣어줌
	
	BoardDAO DAO = BoardDAO.getInstance();
	// 주소값을 받아옴
	
	boolean flag = DAO.insert(board);
	System.out.println(flag);
	
	if (flag){
		response.sendRedirect("board_insert_success.jsp");
		//response.sendRedirect("list.jsp");
		System.out.println("등록완료");
		// flag가 true이면 등록완료이므로 해당 jsp파일로 이동 
	}
	else {
		response.sendRedirect("write.jsp");
		// flag가 false이면 등록완료가 안되었으므로 다시 작성하도록 하기 
	}
    %>