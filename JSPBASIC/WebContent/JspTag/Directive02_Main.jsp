<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main(header + footer)</title>
</head>
<body>

<%@ include file ="Directive02_Header.jsp" %>
		<p>
		하잉 <br>
		홈페이지 방문을 환영합니다!<br>
		여기는 메인 페이지 입니다
		</p>
<%@ include file ="Directive02_Footer.jsp" %>
<!-- include를 통해서 미리 지정한 파일을 불러올 수 있음 (재사용 가능) -->

</body>
</html>