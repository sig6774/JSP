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
	<div align="center">
		<form action="req_album_result_answer.jsp">
			<table border="1">
				<tr>
					<th></th>
					<th>앨범커버</th>
					<th>가수</th>
					<th>앨범제목</th>
					<th>발매일</th>
				</tr>

				<tr>
					<td><input type="radio" name="title" value="sel1"></td>
					<td><img alt="pic1" src="psy.PNG" width="100px" height="100px"></td>
					<td>싸이(PSY)</td>
					<td>THAT THAT</td>
					<td>2022.04.29</td>

				</tr>

				<tr>
					<td><input type="radio" name="title" value="sel2"></td>
					<td><img alt="pic2" src="big.PNG" width="100px" height="100px"></td>
					<td>Bigbang</td>
					<td>봄여름가을겨울(Still Life)</td>
					<td>2022.04.05</td>
				</tr>

				<tr>
					<td colspan="5"><input type="submit" value="확인"></td>
				</tr>

			</table>
		</form>

	</div>
</body>
</html>