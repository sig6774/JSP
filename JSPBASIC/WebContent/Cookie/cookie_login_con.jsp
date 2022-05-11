<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		if(id.equals("abc1234") && pw.equals("aaa1111")) {
			// 로그인 성공이라면 
			System.out.println("로그인 성공");
			Cookie loginCoo = new Cookie("login_cookie", id);
			
			loginCoo.setMaxAge(5);
			// 로그인은 5초 유지 
			response.addCookie(loginCoo);
			// 쿠키가 클라이언트에게 가서 응답할 때 같이 전송되도록
			System.out.println("쿠키 생성");
			
			if (request.getParameter("id_remember") != null){
				// 체크박스 체크 유무 확인
				System.out.println("체크");
				Cookie idMemory = new Cookie("remember_id", id);
				idMemory.setMaxAge(30);
				response.addCookie(idMemory);
				// send.Redirect 할 때 쿠키 값 보내기 위해 사용
			}
			
			
			response.sendRedirect("cookie_welcome.jsp");
			// 로그인이 성공하면 위의 창으로 보냄 
			// 이 요청과 함께 쿠키가 같이 서버에 요청됨

		}
		else {
			response.sendRedirect("cookie_login.jsp");
			// 값이 틀리면 다시 입력할 수 있는 창으로 보냄
		}

	%>
