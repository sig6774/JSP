<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <!-- 자동으로 생성한 문장인데 저것 때문에 오류가 났네...  -->


<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>initializejsp</title>
</head>
<body>
<!-- http://localhost:8181/jspbasic/jsptag/scriptlet.jsp 
root주소 : jspbasic, jsptag안의 scriptlet.jsp파일을 서버가 찾아서 응답을 한 결과를 화면에서 볼 수 있음 
html과 java 모두 사용 가능-->

<% for(int i = 1; i <= 5; i++){%> <!--  자바 코드인 부분만 <% %>를 통해서 구분해야함 --> 
<h2>jsp 작성</h2>
<p> 안녕하세요! 오늘은 5월 6일 금요일입니다.</p>
<p> 신기하고 재밌당  자바 코드만 특정문구로 구분</p>
<% }%> <!--  자바 코드인 부분만 "<% %>"를 통해서 구분해야함 재밌네  -->

<hr>

<h2>구구단 3단</h2>
<% for (int hang = 1; hang <= 9; hang++){ 
	// out.print() : 브라우저에 바로 출력을 실행하는 메소드 
	// 브라우저에 출력할 텍스트나 html 태그는 ""에 감싸서 전달
	// 자바 변수나 메서드의 리턴 값은 바로 작성 가능 
	out.print("3 x " + hang + " = " + (3*hang) + "<br>");
 } %> 
 
 
 <!-- 
 반복문, 조건문을 사용하여 구구단을 홀수단(3,5,7,9)만 브라우저에 출력  -->

<h2> 구구단 홀수만 출력 (반복문 조건문 활용)</h2>

<% for (int hang = 2; hang <= 9; hang++){
if (hang % 2 != 0) {
out.print(hang + "단" + "<br>");



for (int col = 1; col <= 9; col++){
out.print(hang + "x" + col + " = " + (hang*col) + "<br>");
}}}%>


</body>
</html>