<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- <%
	BoardDAO dao = BoardDAO.getInstance();
	List<BoardVO> boards = dao.listBoard();
%> --%>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>BBS Test</title>

<!--게시판만 적용되는 css-->
<style>
.table-striped>tbody>tr {
	background-color: rgba(255, 255, 255)
}

.row h2 {
	color: aliceblue;
}

.pagination-sm {
	margin: 0;
}
</style>
</head>

<body>
	<%@ include file="/include/header.jsp"%>

	<%--   <jsp:include page="/include/header.jsp"/> 
 --%>

	<section>

		<div class="container">
			<div class="row">

				<h2>게시판 목록</h2>
				<c:set var="listboard" value="${listBoard}" />
				<%-- <% if(boards.size() >0 ) {--%>

				<table class="table table-striped"
					style="text-align: center; border: 2px solid #737373">
					<thead>
						<tr>
							<th style="background-color: #9DCAFF; text-align: center;">번호</th>
							<th style="background-color: #9DCAFF; text-align: center;">제목</th>
							<th style="background-color: #9DCAFF; text-align: center;">작성자</th>
							<th style="background-color: #9DCAFF; text-align: center;">내용</th>
							<th style="background-color: #9DCAFF; text-align: center;">작성일</th>
						</tr>
					</thead>
					<c:forEach var="board" items="${listBoard }">
						<!-- jstl 패키지 불러와야 수행가능 
						 listBoard라는 이름의 값을 가져와서 화면에 뿌림 -->

						<%--<% for (BoardVO board : boards) {--%>
						<tbody>
							<tr>
								<%-- <td><%= board.getBoardId() %></td>--%>
								<td>${board.boardId }</td>
								<%-- <td><a href = "Board_content.jsp?bId=<%= board.getBoardId()%>"><%= board.getTitle() %></a></td>--%>
								<td><a href="/WebTemplete/content.Board?bId=${board.boardId}">${board.title}</a>
									<!-- 제목을 클릭하면 해당 게시물로 가도록 지정하고 boardid값도 같이 가도록 설정  --> <%-- <td><%= board.getWriter() %></td>
							<td><%= board.getContent() %></td>
							<td><%= board.getRegDate() %></td> --%>
								<td>${board.writer }</td>
								<td>${board.content }</td>
								<td>${board.regDate }</td>
							</tr>
							<%-- 						<%} %>
						<%} else{ %> --%>
					</c:forEach>

					</tbody>
				</table>

				<div class="text-center">
					<ul class="pagination pagination-sm">
						<li><a href="#">이전</a></li>
						<li class="active"><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#">다음</a></li>
					</ul>
					<button class="btn btn-info pull-right"
						onclick="location.href = '/WebTemplete/write.Board'">글쓰기</button>
					<!-- controller에 write.board로 보내고 regist를 통해서 작성  -->

				</div>

			</div>
		</div>
	</section>

	<%@ include file="/include/footer.jsp"%>


	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>

</html>
