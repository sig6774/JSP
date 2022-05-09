<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--
      - ArrayList를 생성해서 1 ~ 45범위의 난수 6개를 리스트에 저장하세요.
       중복은 발생하면 안됩니다. 중복 방지 로직을 세워서 리스트에 난수를 삽입한 후
      - body태그에 리스트 내부의 값을 출력해 주세요.
       난수 생성은 Random객체든, Math.random()이든 상관 없습니다.
   --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quiz1</title>
</head>
<body>

	<h2>로또 번호 생성 결과!</h2>
	<br>
	<h3>이번주 로또 번호는 이 번호다!</h3>


	<%HashSet<Integer> set = new HashSet<Integer>(); %>
	<% for(int i = 0; i<6; i++) {
    	Random r1 = new Random();  
		set.add(r1.nextInt(45) + 1);
		
    }
    Iterator iter = set.iterator();
    if (set.size() == 6) {
    while( iter.hasNext()){
//    	System.out.println(iter.next() + " ");
    	out.print(iter.next() + " ");
    }
    }
    else{
    out.print("값이 6개가 아니라 출력하지 못했습니다.");
    }

%>
</body>
</html>