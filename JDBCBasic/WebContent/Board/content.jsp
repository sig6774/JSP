<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		int id = Integer.parseInt(request.getParameter("bID"));
		// 요청과 함께 넘어오는 파라미터값(글 번호)을 얻어와서 
		// DAO의 selectOne() 호출하여 객체를 받아오세요
	%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1> ??? 번 게시물 내용</h1>

<p>
	# 작성자 : ?? <br>
	# 제목 : ?? <br>
	# 내용 : <br>
	<textarea rows="5" readonly>??</textarea><br>
	# 작성일 : ?? <br>
</p>

<a href = "list.jsp">글 목록 보기</a>
</body>
</html>