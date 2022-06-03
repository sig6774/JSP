<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- 	<%
		int bid = Integer.parseInt(request.getParameter("bId"));
		BoardVO board = BoardDAO.getInstance().contentBoard(bid);
	%> --%>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

<title>BBS Test</title>

</head>
<body>
	<%@ include file="/include/header.jsp"%>


	<section>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 col-sm-12 join-form">
					<h2>
						게시판 상세보기<small>(디자인이궁금하세요?)</small>
					</h2>
					<c:set var="board" value="${board }" />
					<!-- 해당 jsp에서 사용할 값   -->
					<form action="BoardUpdate.jsp">
						<div class="form-group">
							<label>등록일</label> <input type="text" class="form-control"
								value="${board.regDate }">
						</div>
						<div class="form-group">
							<label>글번호</label> <input type="text" class="form-control"
								value="${board.boardId}" name="Bid">
						</div>
						<div class="form-group">
							<label>글쓴이</label> <input type="text" class="form-control"
								value="${board.writer }" name="Bwriter">
						</div>
						<div class="form-group">
							<label>제목</label> <input type="text" class="form-control"
								value="${board.title }" name="Btitle">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" value="${board.content }"
								name="Bcontent" rows="5"></textarea>
						</div>

						<!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
						<div class="form-group">
							<button type="button" class="btn btn-success"
								onclick="location.href = '/MiniProject/Boardlist.Board'">목록</button>
							<button type="button" class="btn btn-info"
								onclick="location.href = '/MiniProject/modify.Board?bId=${board.boardId}'">수정</button>
							<button type="button" class="btn btn-info"
								onclick="location.href = '/MiniProject/delete.Board?bId=${board.boardId}'">삭제</button>
							<!-- bid를 보내서 수정 및 삭제에서 그걸 바탕으로 값을 뿌려주면 될듯? -->

						</div>

					</form>
				</div>
			</div>
		</div>


	</section>

	<%@ include file="/include/footer.jsp"%>


</body>
</html>