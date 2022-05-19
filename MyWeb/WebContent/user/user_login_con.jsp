<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	
	<%
		/*
	   1. 파라미터값 얻어오기 (id, pw)
	   2. DAO 주소값 얻어오기
	   3. 로그인 유효성 검증 메서드 userCheck() 호출하기.
	   - 아이디가 없다면 스크립트 경고창 출력 후 로그인 페이지로 이동 (-1)
	   - 비밀번호가 틀렸다면 비밀번호가 틀렸다고 경고창 출력 후 뒤로가기 (0)
	   - 로그인 성공일 경우 user_mypage.jsp로 리다이렉팅 (1)
	   
	   4. 로그인 성공 시 페이지 이동 전에 getUserInfo()를 호출하여
	    로그인을 성공한 회원의 모든 정보를 받아와서 세션에 저장해 주세요.
	   ( 세션 이름: user, 저장할 값: 로그인 성공한 회원의 UserVO 객체)
	   */
	   
   		request.setCharacterEncoding("utf-8");
		// post방식이므로 utf-8 사용
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.getInstance();
		int check = dao.userCheck(id, pw);
		System.out.println("유효성 검사  : " +check);
		
		if (check == 1){
			// id와 pw가 같다면 
			
			session.setAttribute("user", dao.getUserInfo(id));
			// getUserInfo()를 통해서 user라는 이름의 객체를 가진 session정보 저장 
			
			response.sendRedirect("user_mypage.jsp");
			// 페이지 이동 
		}
		else if (check == 0){ 
		// pw가 틀리다면 
		%>
		
			<script>
				alert("비밀번호가 틀렸습니다.");
				history.back();
			</script>
		<% } else{
			// 아이디가 틀리다면 
	%>
	<script>
		alert("아이디가 없습니다. 회원가입해주세요")
		location.href = "user_login.jsp";
	</script>
	
	<% }  %>