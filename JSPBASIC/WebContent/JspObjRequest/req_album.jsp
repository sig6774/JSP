<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table, td, th {
	border: 5px solid black;
	border-collapse: collapse;
}

table {
	width: 800px;
	height: 500px;
}

th, td {
	text-align: center;
}
</style>
</head>
<body>

	<form action="req_album_result.jsp" method="post">

		<table border="1">
			<thead>
				<tr>
					<th></th>
					<th>얼굴</th>
					<th>이름</th>
					<th>제목</th>
					<th>생년월일</th>
				</tr>
			</thead>
			<tbody>


				<tr>
					<td><input type="radio" name="title1" value="1"></td>
					<td><img alt="s" src="kim.PNG" width="350px" height="200px">

					</td>
					<td>김용명</td>
					<td>루피</td>
					<td>1978. 10. 2</td>
				</tr>

				<tr>
					<td><input type="radio" name="title1" value="2"></td>
					<td><img alt="s" src="kim2.PNG" width="350px" height="200px">
					</td>
					<td>김용명</td>
					<td>선글라스</td>
					<td>1978. 10. 2</td>
				</tr>
			</tbody>

			<tfoot>
				<tr>
					<td colspan="5"><input type="submit" value="확인"></td>
				</tr>
			</tfoot>

		</table>

	</form>

</body>
</html>