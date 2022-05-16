<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		int id = Integer.parseInt(request.getParameter("bID"));
		// 요청과 함께 넘어오는 파라미터값(글 번호)을 얻어와서 
		// DAO의 selectOne() 호출하여 객체를 와야함
		BoardDAO dao = BoardDAO.getInstance();
		BoardVO vo = dao.selectOne(id);
		// 요청과 함께 넘어오는 파라미터값을 기준으로 객체를 반환하는 메서드를 작성해서 객체 반환
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> <%= vo.getBoardId() %> 번 게시물 내용</h1>

<p>
	# 작성자 : <%= vo.getWriter() %> <br>
	# 제목 : <%= vo.getTitle() %> <br>
	# 내용 : <br>
	<textarea rows="5" readonly><%= vo.getContent() %></textarea><br>
	# 작성일 : <%= vo.getRegDate() %> <br>
</p>

<a href = "list.jsp">글 목록 보기</a>
<a href="update.jsp?bID=<%=vo.getBoardId() %>" >글 수정</a>
<!-- 값을 수정하기 위해서는 id값이 있어야 하기 때문에 update에도 값을 보내줘서 값을 기준으로 다시 찾아서 수정하도록 로직을 진행 -->

<a href="modify.jsp?bID=<%=vo.getBoardId() %>">글 수정(새로운 방법)</a>


</body>
</html>