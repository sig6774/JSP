<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%
    /*
	   - 수정에 필요한 파라미터값을 불러와서 그것을 토대로
	   BoardVO 객체를 생성하세요. (제목, 내용만 수정됩니다.)
	   
	   - BoardDAO의 update()를 이용하여 수정한 객체를 DB에 적용시켜 주시고
	    결과가 성공이라면 해당 글 상세보기 페이지로 이동시켜 주세요.
	    결과가 실패라면 list.jsp로 리다이렉팅 해주세요.
   */
	%>
	
	<%
    	request.setCharacterEncoding("utf-8");

		int bId = Integer.parseInt(request.getParameter("bId"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		// modify에서 값을 받아옴
		
		BoardVO moBoard = new BoardVO();
		BoardDAO dao = BoardDAO.getInstance();
		moBoard = dao.selectOne(bId);
		// 받아온 bId를 통해서 검색하여 값이 들어있는 객체 생성
		moBoard.setTitle(title);
		moBoard.setContent(content);
		// 값 변경 
		
		if (dao.update1(moBoard)){%>
			<h2>수정이 완료되었습니다.</h2>
			<!-- <a href = "content.jsp?bID=<%=moBoard.getBoardId()%>">상세보기 이동</a>0 -->
			<% response.sendRedirect("content.jsp?bID="+ moBoard.getBoardId());%>		
		<% // 수정이 완료되면 bid값을 content.jsp에 보내줘서 상세보기 가능하도록 지정
		//			<% response.sendRedirect("content.jsp?bID= ""<%=moBoard.getBoardId()%>")%>		

		}
		else{
	%>		<h2>수정을 완료하지 못했습니다.</h2>
			<a href = "list.jsp">리스트 이동 </a>
	<%}
	// 수정이 완료되지 못했으면 데이터를 다시 모두 볼 수 있도록 list.jsp로 이동 %>