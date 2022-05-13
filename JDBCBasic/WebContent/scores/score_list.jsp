<%@page import="kr.co.jsp.score.model.ScoreVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.jsp.score.model.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		// DB테이블에 존재하는 모든 학생의 점수를 현재 JSP 파일로 가지고 와서 
		// 테이블 태그로 출력 
		// DAO에게 조회를 요청하는 로직을 만들면 됨
		
		ScoreDAO dao = ScoreDAO.getInstance();
		// ScoreDAO는 객체를 생성할 수 없으므로 static의 특징으로 scoreDAO 값을 가져옴 
		List<ScoreVO> scoreList = dao.selectAll();
		System.out.println(scoreList);
		// dao.selectAll()은 List<ScoreVO>타입의 모든 score 데이터를 모두 리턴

	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 학생들의 전체 성적 조회</h1>
	
	<form action="search.jsp">
		검색 : <input type = "text" name = "keyword" placeholder = "검색할 이름을 입력">
		<input type = "submit" value = "검색">
	</form>
	<!-- 이름을 search.jsp에 보내서 값을 바탕으로 sql 수행하면 될 듯? -->
	
	<table border = "1">
		<tr>
			<th>id</th>
			<th>name</th>
			<th>Kor</th>
			<th>Eng</th>
			<th>Math</th>
			<th>Total</th>
			<th>Avg</th>
			<th>비고</th>
		</tr>
		
		<% for (ScoreVO scores : scoreList) { // 향상 for문을 사용해 직접 값에 접근 %>
			<tr>
				<td><%= scores.getId() %></td>
				<td><%= scores.getName() %></td>
				<td><%= scores.getKor() %></td>
				<td><%= scores.getEng() %></td>
				<td><%= scores.getMath() %></td>
				<td><%= scores.getTotal() %></td>
				<td><%= scores.getAvg() %></td>
				<td>
				<a href = "delete.jsp?id=<%=scores.getId()%>">[삭제]</a>
				<!-- 삭제를 클릭하면 delete.jsp에 id값도 같이 보냄 -->
				</td>
			</tr>
		<%} %>
	</table>
	
	<br>
	
	<a href = "insert_form.jsp">새로운 점수 등록하기</a>
	
</body>
</html>