<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%--
       bmi지수 계산 공식: 체중(kg) / 신장(m) * 신장(m)
       - bmi지수가 25를 초과한다면 "당신은 과체중입니다." 를 출력
       - 18.5미만이라면 "당신은 저체중입니다." 를 출력
       - 나머지는 "당신은 정상체중입니다." 를 출력하세요.
       
       주의!) 
       request.getParameter()의 리턴 타입은 String입니다.
       숫자가 전달되어도 타입이 문자열입니다.
       그렇기 때문에 bmi 지수를 계산하려면 실수나 정수로 변환 후 계산해야 합니다.
       Integer.parseInt(문자열), Double.parseDouble(문자열)
       신장 -> cm, 체중 -> kg 두 값 모두 소수점 포함 값으로 받도록 하겠습니다.
     --%>
     <%
     String s_m = request.getParameter("cm");
     String k = request.getParameter("kg");
     %>
     
     <%
	double i_m = (Double.parseDouble(s_m)/100);
	double i_k = Double.parseDouble(k);
	
	double bmi = i_k / (i_m *i_m);
	String c = String.format("%.2f", bmi);
	double bmi1 = i_k / (i_m * i_m);
	bmi1 = Math.round(bmi1*100) / 100.0;
	
	%>
<html>
<head>
<meta charset="UTF-8">
<title>bmi</title>
</head>
<body>

<h2>체질량 지수(BMI) 계산</h2>
<hr>



<p>- 신장 : <%= s_m %> cm</p> 
<p>- 체중 : <%= k %> kg</p>
<p> BMI지수 : <strong><%= c %></strong></p> <br>
<p> MATH함수를 사용한 BMI지수 : <strong><%= bmi1 %></strong> </p><br>


	<%
	if (bmi > 25) {
		out.print("당신은 과체중입니다.");
	}
	else if (bmi < 18.5){
		out.print("당신은 저체중입니다.");
	}
	else {
		out.print("당신은 정상체중입니다.");
	}
	
	%>

</body>
</html>