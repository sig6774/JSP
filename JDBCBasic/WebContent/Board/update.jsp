<%@page import="kr.co.jsp.board.model.BoardVO"%>
<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!-- 		// 그냥 아이디만 받으면 여기서 새로운 입력창으로 수정할 값을 넣고 update_con.jsp에서 값들을 수정하면 될듯?
 -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시글 수정</h2>
	<form action="update_con.jsp" method="post">
		<p>
			# 작성자 : <input type="text" name="writer"><br>
			# 수정할 제목 : <input type = "text" name = "title"><br>
			# 수정할 글내용 : <br>
			<textarea rows="3" name = "content"></textarea><br>
			<input type = "submit" value = "수정">
			<!-- submit 등록을 클릭하게 되면 post방식으로  write_con.jsp로 값이 이동 -->
		</p>
	</form>

</body>
</html>