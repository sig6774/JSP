<%@page import="kr.co.jsp.user.model.UserVO"%>
<%@page import="kr.co.jsp.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    /*
	    1. 폼 데이터 처리 (기존 비번, 변경 비번)
	    2. dao주소값을 받아오시고, userCheck()를 활용하여
	     	기존 비번과 아이디 정보를 바탕으로 해당 비밀번호가 일치하는지를 검사.
	     (id는 세션에서 구해옵니다.)
	    
	    3. 기존 비밀번호가 일치한다면 비밀번호 변경 메서드 changePassword() 호출.
	    4. "비밀번호가 정상적으로 변경되었습니다." 경고창 출력 후 mypage 이동.
	    5. 현재 비밀번호가 불일치 -> "현재 비밀번호가 다릅니다." 경고창 출력 후 뒤로가기.
    */
    %>
    <% 
		request.setCharacterEncoding("utf-8");
	    // post방식으로 인해 발생 
		String oldPw = request.getParameter("old_pw");
		String newPw = request.getParameter("new_pw");
		// form에서 보낸 데이터 처리
		
		UserDAO dao = UserDAO.getInstance();
		// 주소값 가져오기
		
		UserVO user = (UserVO) session.getAttribute("user");
		// 세션에 저장한 값을 가져오기 

		int num = dao.userCheck(user.getUser_id(), oldPw);
		// id와 pw가 db에 저장된 것과 같은지 유효성 검사
		
		if (num == 1){
			dao.changePassword(user.getUser_id(), newPw);
			// changePassword는 매개변수로 id와 새로운 pw를 받아서 기존 pw update 진행
			%>
			<script>
				alert("비밀번호가 정상적으로 변경되었습니다.");
				location.href = "user_mypage.jsp";
			</script>
			
			
		<% } else {%>
			<script>
				alert("현재 비밀번호가 다릅니다.");
				history.back();
			</script>
 		<% } %>
 
