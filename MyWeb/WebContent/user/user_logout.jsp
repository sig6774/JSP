<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		session.invalidate();
		// 세션 초기화
	%>
	
	<script>
		alert("로그아웃 처리되었습니다.");
		location.href = "/MyWeb";
	</script>