<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	tbody {
		font-size: 20px;
	}
	
	.page-link {
		background-color: orange;
	}
	
	.btn-countPerPage{
		background-color : gray;
		color : white;
	}
</style>

</head>
<body>

	<%--
		로그인하지 않은  사용자가 게시판에 들어왔을 경우 돌려보내는 코드를 작성.
	 
	<c:if test="${user == null}">
		<script>
			alert("회원만 이용 가능한 게시판입니다. 로그인 해 주세요.");
			//board_list.jsp로 직접 요청이 들어가는 경우는 없기 때문에
			//컨트롤러를 기준으로 상대 경로로 작성하시든지, 절대 경로로 작성해야 합니다.
			location.href = "user/user_login.jsp";
		</script>
	</c:if>
	
	loginAuthFilter가 있으므로 사용 X
--%>
	<c:if test="${searchFail}">
		<script>
			alert("조회 결과가 없습니다.");
			
			location.href = "/MyWeb/list.board";
		</script>
	</c:if>

	<jsp:include page="../include/header.jsp" />
	<div class="container">
		<h2>My Web게시판</h2>
		
		<span style="float: right; margin-bottom: 15px"> <input
			class="btn btn-countPerPage" type="button" value="10"
			onclick="location.href='/MyWeb/list.board?page=1&cpp=10'">
			<input class="btn btn-countPerPage" type="button" value="20"
			onclick="location.href='/MyWeb/list.board?page=1&cpp=20'">
			<input class="btn btn-countPerPage" type="button" value="30"
			onclick="location.href='/MyWeb/list.board?page=1&cpp=30'">
			<!-- countPerPage를 바꿀 수 있도록 개별 지정했구나! -->
		</span>

		<table class="table table-secondary table-hover table-bordered">
			<thead style="font-size: 25px">
				<tr>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>


			<tbody>
				<c:forEach var="b" items="${bList}">
					<tr>
						<td>${b.boardId}</td>
						<td>${b.writer}</td>
						<!--  <td><a href="/MyWeb/content.board?bId=${b.boardId}&${pc.paging.page == null ? 'page=1&cpp=10' : 'page=${pc.paging.page}&cpp=${pc.paging.countPerPage}'}">${b.title}</a>-->
								<td><a href="/MyWeb/content.board?bId=${b.boardId}">${b.title}</a>
						
						<!-- 제목을 클릭하여 상세보기로 보낼때 값들을 같이 보냄 -->
							&nbsp;&nbsp; <c:if test="${b.newMark }">
								<!-- newMark가 true면 (하루가 지나지 않았으면) -->
								<img alt="newMark" src="/MyWeb/img/icon_new.gif">
							</c:if></td>
						<td><fmt:formatDate value="${b.regDate }"
								pattern="yyyy년 MM월 dd일  a hh시 mm분" /> <!-- fmt태그를 이용하여 format 지정 -->
						</td>
						<td>${b.hit}</td>
					</tr>
				</c:forEach>
			</tbody>

			<%-- 페이징을 처리할 구간 --%>
			<tbody>
				<tr>
					<td colspan="5" align="center">
						<ul class="pagination pagination-lg">

							<%-- 이전 버튼 --%>
							<c:if test="${pc.prev }">
								<!-- request에서 받아온 이름이 pc라는 얘의 prev가 true면 밑에 로직 실행  -->
								<li class="page-item"><a class="page-link"
									href="/MyWeb/list.board?page=${ pc.beginPage-1}&cpp=${ pc.paging.countPerPage}"
									style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">이전</a>
								</li>
							</c:if>

							<%-- 페이지 버튼 --%>
							<c:forEach var="pageNum" begin="${pc.beginPage}"
								end="${pc.endPage}">
								<!-- 반복을 사용해서 진행 -->
								<li class="page-item"><a
									href="/MyWeb/list.board?page=${pageNum }&cpp=${pc.paging.countPerPage}"
									class="page-link"
									style="margin-top: 0; height: 40px; color: pink; border: 1px solid #643691; ${pageNum == pc.paging.page ? 'background-color: orange;' : ''}">${pageNum}</a>
									<!-- 목록을 요청하고 값을 반복문의 값을 넣어줘서 페이지를 넘겨줌  --> <!-- 현재 페이지와 사용자가 요청한 page와 같으면  background color를 색칠 -->
								</li>
							</c:forEach>

							<%-- 다음 버튼 --%>
							<c:if test="${pc.next }">
								<!-- request에서 받아온 이름이 pc라는 얘의 next가 true면 밑에 로직 실행  -->
								<li class="page-item"><a class="page-link"
									href="/MyWeb/list.board?page=${ pc.endPage+1}&cpp=${ pc.paging.countPerPage}"
									style="background-color: #643691; margin-top: 0; height: 40px; color: white; border: 0px solid #f78f24; opacity: 0.8">다음</a>
								</li>
							</c:if>

						</ul>
					</td>
				</tr>
			</tbody>

			<tbody>
				<tr>
					<td colspan="5" align="right">
						<form action="/MyWeb/search.board" class="form-inline">
							<div class="form-group">
								<select name="category" class="form-control">
									<option value="title">제목</option>
									<option value="writer">작성자</option>
									<option value="content">내용</option>
								</select> <input type="text" name="search" placeholder="검색어 입력"
									class="form-control"> <input type="submit" value="검색"
									class="btn btn-default"> <input type="button"
									value="글 작성" class="btn btn-default"
									onclick="location.href='/MyWeb/write.board'">
							</div>
						</form>
					</td>
				</tr>
			</tbody>

		</table>
	</div>

	<jsp:include page="../include/footer.jsp" />

</body>
</html>







