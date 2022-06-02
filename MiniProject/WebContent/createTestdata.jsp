<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	// 테스트 데이터 생성 
		for(int i = 1; i <= 50; i++){
			String writer = "테스트문" + i;
			String title = "테스트용" + i;
			String content = i + "번째 테스트 중입니당~" ;
			BoardDAO.getInstance().regist(writer, title, content);
		}
		out.print("insert 완료!");
	%>   --%>
</body>
</html>