<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
	<% 
		int age = Integer.parseInt(request.getParameter("age"));
		// getparameter는 문자로 반환하기 때문에 int로 변환
		
		if (age >= 20){
			// 내장 객체 response가 제공하는 sendRedirect() 메서드를 통해
			// 원하는 페이지로 강제 이동 가능
			// 괄호 안에 이동시킬 페이지의 URL을 적어주면 됨 
			
			response.sendRedirect("res_basic_ok.jsp");
			// 20이상은 성인 페이지로 보내줌
		}else {
			// 20미만은 아동 페이지로 보내줌
			response.sendRedirect("res_basic_no.jsp");
		}
	%>
	
	
	
	