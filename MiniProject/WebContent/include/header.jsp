<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/custom.css">
<title>BBS Test</title>


<!--메인만 적용되는 css영역-->
<style>
body {
	background-image: /MiniProject/images/main.jpg;
	background-repeat: no-repeat;
	background-size: cover
}
</style>
</head>

<body>

	<nav class="navbar navbar-default" id="nav">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="##">MIN and PARK</a>
		</div>

		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="/MiniProject/index.jsp" style="margin-right: 10px;">메인</a></li>
				<li><a href="/MiniProject/Boardlist.Board">게시판</a></li>
				<!-- 게시판 이동 경로 설정 -->
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">접속하기<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">로그인</a></li>
						<li><a href="/MiniProject/user/user_join.jsp">회원가입</a></li>
					</ul></li>
			</ul>

		</div>
	</nav>
</body>