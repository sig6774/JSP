<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	/*
	    1. 폼 데이터 처리하세요.
	    2. DAO 연동을 통해 updateUser() 메서드를 호출하여 회원 정보를 수정합니다.
	     회원 정보 수정을 성공했다면 세션을 다시 제작해 주셔야 합니다.
	     이름은 똑같이 해서 저장해 주시면 되겠습니다.
	    3. 수정 후 "회원 정보가 수정되었습니다." 를 출력 후 마이페이지로 이동.
	    */
    %>
    
    <%
    	/*
    		1. user_update의 값을 가져옴
    		2. 세션에 저장되어 있는 객체에서 pw를 가져와서 5개를 모두 넣어서 하나의 객체를 만들어줌
    		3. DAO에서 값들을 수정 (name, email, address)
    		4. 수정이 완료되었으면 세션을 다시 만듬
    	*/
		request.setCharacterEncoding("utf-8");
    
    	String id = request.getParameter("id");
    	String name = request.getParameter("name");
    	String email = request.getParameter("email");
    	String address = request.getParameter("address");
    	
		UserVO user = (UserVO) session.getAttribute("user");
		// 세션값 가져옴 
		String pw = user.getUser_pw();
		// 세션에 저장되어 있는 값에서 pw를 가져옴 
		
		UserVO updateUser = new UserVO(id, pw, name, email, address);
		// 값 넣어줌
		
		UserDAO dao = UserDAO.getInstance();
		// 주소값 불러옴 
		
		dao.updateUser(updateUser);
		// 유저 정보 변경  
		
		session.setAttribute("user", dao.getUserInfo(updateUser.getUser_id()));
		// 중요!!!
		// 세션을 다시 저장해야 업데이트 된 사용자의 정보를 유지할 수 있음 
    %>
    
   <script>
   		alert = "회원 정보가 수정되었습니다.";
   		location.href = "user_mypage.jsp";
   </script>