<%@page import="kr.co.pr.user.model.UserDAO"%>
<%@page import="kr.co.pr.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>

<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("ID");
	String pw = request.getParameter("PW");
	String name = request.getParameter("NAME");
	String email = request.getParameter("EMAIL");
	String address = request.getParameter("ADDRESS");
	
	String first = request.getParameter("FIRST_TEL");
	String second = request.getParameter("SECOND_TEL");
	String third = request.getParameter("THIRD_TEL");
	
	String final_tel = first + second + third;
	System.out.println(final_tel);
	
	System.out.println(id);
	UserVO upUser = new UserVO(id, pw, name, final_tel, email, address);
	System.out.println(upUser.getName());
	System.out.println(upUser.getUserId());
	System.out.println(upUser.getUserPw());
	System.out.println(upUser.getNumber());
	System.out.println(upUser.getEmail());
	System.out.println(upUser.getAddress());
	
	boolean flag = false;
	flag = UserDAO.getInstance().updateUser(upUser);
	System.out.println(flag);
	
	if (UserDAO.getInstance().checkId(id)) {
		System.out.println("아이디 중복확인 완료");
	
		if (flag) {
	%>
	<script>
		alert("회원정보 수정완료");
		location.href = "user_login.jsp";
	</script>
	
	<%
		} else {
	%>
	
	<script>
		alert("회원정보를 수정하지 못했습니다. 다시 로그인 해주세요");
		location.href = "user_login.jsp";
	</script>
	<%
		}
	}
	
	%>