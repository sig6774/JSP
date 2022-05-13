<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
	   //BoardDAO 클래스의 selectAll() 을 호출하여
	   //DB에 들어있는 모든 글들을 list로 받아 오셔야 합니다.
	   //리턴값으로 받은 리스트를 body태그에 반복문을 사용하여 하나씩 작성 (테이블 형식으로).
	   //번호, 작성자, 제목, 비고(삭제)
	   //조건문을 사용하여 DB에서 얻어온 글이 하나도 없을 때는
	   //게시글이 존재하지 않는다 라는 글을 출력해 주세요.
	%>
	
	<%
		BoardDAO dao = BoardDAO.getInstance();
		// 주소값 받아옴 
		List<BoardVO> boardlist = dao.selectAll();
		// 모두 조회한 값 받아옴
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1> 게시글 목록 </h1>

	<% if (boardlist.size() > 0 ) {%>
	<table border = "3">
		<tr>
			<th>name</th>
			<th>writer</th>
			<th>title</th>
			<th>etc</th>
		</tr>
		
		<% for (BoardVO board : boardlist){ %>
		<tr>
			<!-- board객체에서 값을 get -->
			<td><%= board.getBoardId() %></td>
			
			<td><%= board.getWriter() %></td>
			<td>
			<a href="content.jsp?bID=<%=board.getBoardId() %>" ><%= board.getTitle() %></a>
			</td>
			<td>
				<a href = "delete.jsp">
				삭제
				</a>
			</td>
		</tr>
		<%} %>
		<%} else{ %>
		<h3>게시글이 존재하지 않습니다!</h3>
		<a href = "write.jsp">새 글 쓰기</a>
		<%} %>
	
	
	</table>
</body>
</html>