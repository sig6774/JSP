<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	    	request.setCharacterEncoding("utf-8");
			int bId = Integer.parseInt(request.getParameter("Bid"));
			// 주소에 묻힌 값 가져오기
			String title = request.getParameter("Btitle");
			String content = request.getParameter("Bcontent");
			System.out.println("content의 값 가져오는지 확인" + bId);
			
			BoardDAO.getInstance().updateBoard(bId, title, content);
			// 수정이 완료되었으면 list로 보내기
		%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <h2>수정이 완료되었습니다!</h2>
	<h3>목록페이지로 돌아가기 </h3> -->
	<script>
		alert('수정이 완료되었습니다');
		location.href='Boardlist.jsp';
	</script>

</body>
</html>