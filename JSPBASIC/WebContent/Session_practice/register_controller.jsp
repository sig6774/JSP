<%@page import="main.java.user.User"%>
<%@page import="main.java.user.UserRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	request.setCharacterEncoding("UTF-8");
    	
    	// 값 가져오기
    	String id = request.getParameter("account");
    	String pw = request.getParameter("password");
    	String name = request.getParameter("name");
    	String nick = request.getParameter("nickname");
    		
    	
		User user = new User(id, pw, name, nick);
		// getparamter를 통해서 받은 값을 User객체에 바로 전달(변수 초기화)
		UserRepository.save(user);
		// 유저리스트에 static 메소드인 save를 활용하여 User객체를 userRepository에 넣기 
		// static 메소드는 객체 생성 X
		
		UserRepository.showUsers();
		// 잘 저장되었는지 확인 
		
		response.sendRedirect("register_result.jsp");
		
		
    %>