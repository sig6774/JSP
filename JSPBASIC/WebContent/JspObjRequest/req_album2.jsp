<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
table {
	width: 800px;
}

tr {
	text-align: center;
}
</style>
</head>
<body>
	<!-- form과 radio button 삭제하고 제목을 클릭하여 연동하도록 구성 -->
	<div align="center">
		<table border="1">
			<tr>
				<th>앨범커버</th>
				<th>가수</th>
				<th>앨범제목</th>
				<th>발매일</th>
			</tr>

			<tr>
				<td><img alt="pic1" src="psy.PNG" width="100px" height="100px"></td>
				<td>싸이(PSY)</td>
				<td><a href="req_album_result_answer.jsp?title=sel1"> 
				<strong>THAT THAT</strong> </a> <!-- 제목을 클릭하면 해당  jsp파일로 이동하고 값을 부여하여 구분할 수 있게 해줌--></td>
				<td>2022.04.29</td>

			</tr>

			<tr>
				<td><img alt="pic2" src="big.PNG" width="100px" height="100px"></td>
				<td>Bigbang</td>
				<td><a href="req_album_result_answer.jsp?title=sel2">
						<strong>봄여름가을겨울(Still Life)</strong> </a></td>
				<td>2022.04.05</td>
			</tr>


		</table>

	</div>
</body>
</html>