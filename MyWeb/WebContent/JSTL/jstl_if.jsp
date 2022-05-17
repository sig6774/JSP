<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%-- jstl을 사용하기 위해서는 외부 태그 라이브러리 선언을 해야함 --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- c:set을 사용하게 되면 변수 선언 가능  
		 JSTL로 변수를 선언하면 EL안에서 활용가능 
		 값도 EL을 이용해서 매겨줄 수 있음 
		 EL이 타입을 자동으로 인식해서 정해줌 
		 내장 객체를 지정할 수도 있음
		 그냥 setAttribute랑 같다고 생각하면 될 듯? --%>
	<c:set var="age" value ="${param.age}" />
	<%-- c:set을 이용해서 지정한 변수는 scriptlet의 자바 변수와는 다르고 
		 내장객체에 지정하는 데이터로 활용되기 때문에 EL이 가능  --%>
	<p>
		나이 : ${age }세 <br>
	<%-- http://localhost:8181/MyWeb/JSTL/jstl_if.jsp?age=15을 통해 값 화면에 출력 가능  --%>
		
		<%-- 조건문 활용  --%>
		<c:if test="${age >= 20}">
			<h2>당신은 성인입니다.</h2>
		</c:if>
	</p>
	
</body>
</html>