<%@page import="kr.co.pr.user.model.UserVO"%>
<%@page import="kr.co.pr.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("ID");
		String pw = request.getParameter("PW");
		String name = request.getParameter("NAME");
		
		// telephone은 일단 문자로 받아서 문자열로 합친 뒤 int로 바꿔주기 
		String firstNum = request.getParameter("first");
		String secondNum = request.getParameter("second");
		String thirdNum = request.getParameter("third");
		
		// 이메일은 select 이거 어떻게 하지?
		// select는 배열로 들어오기 때문에 이렇게 지정 
		// 나중에 합쳐주자 
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		
		// 주소 
		// 나중에 sql에 넣을때 합쳐주자 
		String add1 = request.getParameter("ADDR1");
		String add2 = request.getParameter("ADDR2");
		
		// 최종 전화번호 
		String telephone = firstNum + secondNum + thirdNum;
		
		// 이메일
		
		String e = "";
		if (email2.equals("naver")){
			e = "@naver.com";
		} else if (email2.equals("google")){
			e = "@google.com";
		} else{
			e = "@daum.net";
		}
		
		String email = email1 + e;
		

		
		// 주소 
		String address = add1 + add2;
		
		UserVO newuser = new UserVO(
				id, 
				pw, 
				name, 
				telephone, 
				email, 
				address
				);
		System.out.println(UserDAO.getInstance().checkId(id));
		System.out.println(id);
		
		if (UserDAO.getInstance().checkId(id)){
			// 동일한 id가 없다면
			System.out.println("check완료");
			
			if (UserDAO.getInstance().registUser(newuser)){ %>
				<script>
				
					alert('등록완료');
					location.href = 'user_login.jsp';
				</script>
			<% }
			

		} else{ %>
			<script>
			alert('등록실패');
			</script>
		<%
		}
		
	%>
