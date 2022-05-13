<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ page isErrorPage="true" %>
<% // 에러페이지인 error_page02에서는 에러페이지가 맞는지 체크 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p> 
		요청 처리과정에서 에러가 발생했습니다. <br>
		빠른 시간 내 문제를 해결하겠습니다. <br>
		잠시만 기다려주세요 ㅠㅠ
	</p>
	
	<p>
		에러원인 : <%= exception.getMessage() %>
		<br>
		pst : <%= exception.printStackTrace()%>
	</p>
</body>
</html>