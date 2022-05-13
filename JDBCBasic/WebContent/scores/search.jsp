<%@page import="kr.co.jsp.score.model.ScoreVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.jsp.score.model.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
		String keyword = request.getParameter("keyword");
		// score_list에서 보낸 keyword라는 이름을 가진 값을 가져옴
		// 김이라고만 입력해도 김씨가 다 나오거나 길동이라는 이름이 다 나오게 함 
		// LIKE % " "%를 사용해서 찾으면 될 듯?
		// 틀렸네... 
		// pstmt.setString()은 ?를 채워줄 때 ''도 채워서 넣어주기 때문에 오류남 
		// ?에 %keyword% 이렇게 넣으면 될 듯
		String included_keyword = "%" + keyword + "%";
		
		/*
		SQL문에서 LIKE 절을 사용할 때 %를 ?에 직접 붙이면 정상 동작이 안됨
		?를 채울 때 pstmt객체의 setString()을 이용해서 채우는데 
		setString()은 ''를 자동으로 추가해줌 
		그렇기 때문에 %가 '' 안으로 들어가지 못하는 상황이 발생
		SQL에는 ?만 사용하고 보내는 값에 %를 붙여서 보내면 됨
		*/
		
		 /*
	       DAO클래스에 search라는 이름의 메서드를 선언해서 검색 결과를 리턴하세요.
	       리턴된 결과를 테이블 형식으로 body 내부에 출력해 주시면 되겠습니다.
	       테이블 형식은 score_list.jsp에 있는 테이블을 참조하세요.
	       
	       검색 결과가 없다면 브라우저 화면에 테이블 대신 '검색 결과가 없습니다.'
	       라고 출력하시고 목록으로 돌아갈 수 있는 링크를 추가하세요.
	      */
	%>
	
	<%
		ScoreDAO dao = ScoreDAO.getInstance();
		List<ScoreVO> conditional_search = dao.search(included_keyword);
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%
			if (conditional_search.size() > 0){ %>
	<table border = "1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>Kor</th>
			<th>Eng</th>
			<th>Math</th>
			<th>Total</th>
			<th>Avg</th>
		</tr>
		
		<% for (ScoreVO scores : conditional_search) { // 향상 for문을 사용해 직접 값에 접근 %>
			<tr>
				<td><%= scores.getId() %></td>
				<td><%= scores.getName() %></td>
				<td><%= scores.getKor() %></td>
				<td><%= scores.getEng() %></td>
				<td><%= scores.getMath() %></td>
				<td><%= scores.getTotal() %></td>
				<td><%= scores.getAvg() %></td>
			</tr>
		
		<%} %>
	</table>
			<% } else {
		%>
		<script>
    	alert("검색결과가 없습니다.")
    	location.href = "score_list.jsp";
    </script>
    
    <%} %>

</body>
</html>