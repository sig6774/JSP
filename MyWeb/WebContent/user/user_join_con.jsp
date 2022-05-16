<%@page import="kr.com.jsp.user.model.UserVO"%>
<%@page import="kr.com.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	/*
    	사용자가 입력한 id를 먼저 얻어와서 중복 체크 먼저 진행 
    	*/
    	
    	request.setCharacterEncoding("utf-8");
    
    	String id = request.getParameter("id");
    	
    	UserDAO dao = UserDAO.getInstance();
    	if (dao.confirmID(id)){
    		// if안에는 true이므로 아이디가 중복이라는 뜻 %>
    		<script>
    			alert("아이디가 중복되었습니다.");
    			history.back();
    			<%-- 뒤로가기 --%>
    		</script>
    	<% }
    	else{ // 아아디가 중복되지 않음 (회원가입 진행)
    		String pw = request.getParameter("pw");
    		String name = request.getParameter("name");
    		String email = request.getParameter("email");
    		String address = request.getParameter("address");
    		UserVO newUser = new UserVO(id, pw, name, email, address);
    		dao.insertUser(newUser);
    		// 값들 페이지에서 다 받아서 UserVO 객체에 값들을 넣어줌
    		// insertUser(user객체)를 통해서 DB에 insert 진행 
    		
    		// 경고창으로 회원가입을 환영합니다!라고 띄운뒤 user_login.jsp로 이동
    		%>
    		<script>
    			alert("회원가입을 환영합니다!")
    			location.href = "user_login.jsp";
    		</script>
    	<%}
    %>