<%@page import="kr.co.pr.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
	if (session.getAttribute("userInfo") == null) {
%>

<script>
	alert("로그인을 먼저 해주세용");
	location.href = "user_login.jsp";
	/* 로그인 화면으로 보냄 */
</script>

<%
	} else {
UserVO user = (UserVO) session.getAttribute("userInfo");
// 로그인을 했다면 즉 세션에 유저 정보가 있다면 세션 정보 가져오기
%>
<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">

</head>
<body>
	<jsp:include page="../include/header.jsp" /> 


	<section>
		<div class="container">
			<div class="row join-wrap">
				<!--join-form을 적용한다 float해제 margin:0 auto-->
				<div class="col-xs-12 col-md-9 join-form">

					<div class="titlebox">MEMBER INFO</div>

					<form action="user_update_con.jsp" method="post">
						<p>*표시는 필수 입력 표시입니다</p>
						<table class="table">
							<tbody class="m-control">
								<tr>
									<td class="m-title">*ID</td>
									<td><input class="form-control input-sm"
										placeholder=<%=user.getUserId()%> name="ID"></td>
								</tr>
								<tr>
									<td class="m-title">*이름</td>
									<td><input class="form-control input-sm"
										placeholder=<%=user.getName()%> name="NAME"></td>
								</tr>
								<tr>
									<td class="m-title">*비밀번호</td>
									<td><input class="form-control input-sm"
										placeholder=<%=user.getUserPw()%> name="PW"></td>
								</tr>
								<tr>
									<td class="m-title">*비밀번호확인</td>
									<td><input class="form-control input-sm"
										placeholder=<%=user.getUserPw()%>></td>
								</tr>
								<tr>
									<td class="m-title">*E-mail</td>
									<td><input class="form-control input-sm"
										placeholder=<%=user.getEmail()%> name="EMAIL"> <!-- @ <select
										class="form-control input-sm sel">
											<option>naver.com</option>
											<option>gmail.com</option>
											<option>daum.net</option> 
									</select>
										<button class="btn btn-info">중복확인</button></td>-->
								</tr>
								<tr>
									<td class="m-title">*휴대폰</td>
									<td><input class="form-control input-sm sel"
										name="FIRST_TEL"> - <input
										class="form-control input-sm sel" name="SECOND_TEL"> -
										<input class="form-control input-sm sel" name="THIRD_TEL"></td>
								</tr>
								<tr>
									<td class="m-title">*주소</td>
									<td><input class="form-control input-sm add"
										placeholder=<%=user.getAddress()%> name="ADDRESS"></td>
								</tr>

							</tbody>
						</table>

						<div class="titlefoot">
							<button type="submit" class="btn"
								onclick="location.href = 'user_update_con.jsp'">수정</button>
							<button class="btn">목록</button>
						</div>
					</form>

				</div>


			</div>

		</div>

	</section>
	<jsp:include page="../include/footer.jsp" /> 


	<footer>
		<div class="copyright py-4 text-center text-white">
			<div class="container bounceIn animate">
				<small>Copyright <!-- &copy; --> 2019.<a href=""> Min
						and Park</a></small>
			</div>
		</div>
	</footer>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>
<%}%>