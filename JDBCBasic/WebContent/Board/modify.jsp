<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		/*
			사용자에게 본인이 썼던 글을 기본적으로 제공하고 
			원하는 항목만 수정할 수 있게 폼을 제공 
			selectOne()메서드를 다시 한 번 호출하여 글 번호에 해당하는 
			모든 정보를 얻어와야함
		*/
		
		int bID = Integer.parseInt(request.getParameter("bID"));
		BoardVO board = BoardDAO.getInstance().selectOne(bID);
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>
		<%= board.getBoardId() %>번 게시물 내용수정
	</h1>
	
	<form action="modify.con.jsp" method = "post">
		<input type ="hidden" name = "bId" value = "<%=board.getBoardId() %>">
		<!-- hidden을 사용하게 되면 글번호가 화면에는 노출안됨 -->
	
		<!-- 이미 저장되어 있는 값들을 value를 통해서 미리 넣어놓음 -->
		# 작성자 : <input type = "text" name = "writer" value = "<%=board.getWriter() %>" readonly > <br>
		
		# 제목 : <input type = "text" name = "title" value = "<%= board.getTitle() %>"><br>
		
		# 내용 : <br>
		<textarea rows = "5" name = "content"> <%= board.getContent() %></textarea>
		
		<input type = "submit" value = "수정"> 
		  
	</form>
	
	

</body>
</html>