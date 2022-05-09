<%@page import="java.util.*"%>
<%@page import="java.util.Collections"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
      - ArrayList를 생성해서 1 ~ 45범위의 난수 6개를 리스트에 저장하세요.
       중복은 발생하면 안됩니다. 중복 방지 로직을 세워서 리스트에 난수를 삽입한 후
      - body태그에 리스트 내부의 값을 출력해 주세요.
       난수 생성은 Random객체든, Math.random()이든 상관 없습니다.
   --%>

<% 
	List<Integer> n = new ArrayList<> ();
	Random r1 = new Random();
	
	while(n.size() < 6){ // 이게 핵심 중복 제거 논리 
		
		int temp_num = (r1.nextInt(45) + 1);
		
		if (!n.contains(temp_num))  {
			
			n.add(temp_num);
		}
	}
	Collections.sort(n);
	%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>로또 번호 생성 결과!</h2>
	<br>
	<h3>이번주 로또 번호는 이 번호다!</h3>
	
	번호 : 
	<% for (int i = 0; i < n.size(); i++) {
		out.print(n.get(i) + " ");
		
	}
	%>
</body>
</html>