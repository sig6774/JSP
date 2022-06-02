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
								<td><a
									href="/WebTemplete/content.Board?bId=${board.boardId}">${board.title}</a>
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
						<!-- 이전 버튼  -->
						<c:if test="${page.previousButton }">
							<li><a
								href="/MiniProject/Boardlist.Board?pagenum=${page.beginPage-1 }&perpage=${page.page.getPerPage()}"
								style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a></li>
							<!-- 현재 페이지번호와 페이지당 몇개씩 보여주는지를 Generatepage와 page객체에 이전 버튼을 클릭했을 때값을 보내줌  -->
							<!-- 만약에 1페이지인데 이전버튼을 누르면 어떻게 해야할까? 조건문 써서 pagenum이 1보다 작으면 그냥 다시 back시킬까? -->
						</c:if>
						<c:forEach var="viewpage" begin="${page.beginPage }" end="${page.endPage }">
						<!-- 반복  -->
						<li class="active"><a href="/MiniProject/BoardList.Board?pagenum=${viewpage }&perpage=${page.page.getPerPage()}">${viewpage}</a></li>
						<!-- 반복문을 돌리기 때문에 viewpage로 해서 현재 페이지 값을 가져옴  -->
						<!-- 페이지 이동 클릭하면 파라미터값은 가지만 화면에 보이지 않음 -->

						</c:forEach>
						<c:if test="${page.nextButton }">
							<li><a
								href="/MiniProject/Boardlist.Board?pagenum=${page.beginPage+1 }&perpage=${page.page.getPerPage()}"
								style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a></li>
						</c:if>
						<!-- 페이지 이동했다가 다시 이전버튼 누르면 오류남  이거 고치기 ================================================= -->
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
