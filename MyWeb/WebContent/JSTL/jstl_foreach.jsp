<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%
		int total = 0;
		for (int i = 1; i<= 100; i++ ){
			total += i;
		}
		out.print("<h4>1부터 100까지의 누적합 : "+ total + "<br>" );
	%> --%>
	
	<c:set var = "total" value = "0" />
	<%-- 변수 선언 --%>
	<c:forEach var = "i" begin ="1" end = "100" step = "1">
		<c:set  var = "total" value = "${total + i }"/>
	</c:forEach>
	
	<h4>1부터 100까지의 누적합 : ${total }</h4>
	
	<hr>
	
	<h4>구구단 4단</h4>
	
	<c:forEach var = "hang" begin = "1" end = "9">
		4 X ${hang } = ${4*hang }<br>		
	
	</c:forEach>
	
	<hr>
	
	짝수 단 출력 <br>
	<hr>
	
	
	
	<c:forEach var = "front" begin = "2" end = "9" step = "2">
		<c:forEach var = "back" begin = "1" end = "9" >
			${front } x ${back } = ${front * back }<br>
		
		</c:forEach>
		${'-------------------------------------------'}<br>
	</c:forEach>
	
	
	<h2>배열이나 컬렉션 내부의 값을 출력</h2>
	<c:set var = "arr" value="<%=new int[] {1, 3, 5, 7, 9} %>"/>
	<c:forEach var = "n" items = "${arr }">
	<%-- 배열은 items를 통해서 값 출력 --%>
	  ${n }
		
	
	</c:forEach>
</body>
</html>