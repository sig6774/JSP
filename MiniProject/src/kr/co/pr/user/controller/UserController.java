package kr.co.pr.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.user.service.DeleteService;
import kr.co.pr.user.service.IUserService;
import kr.co.pr.user.service.JoinService;
import kr.co.pr.user.service.LoginService;


@WebServlet("*.User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService sv;
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String uri = request.getRequestURI();
			// 요청했을 때의 uri 값을 가져옴 
			String path = request.getContextPath();
			uri = uri.substring(path.length() + 1 , uri.lastIndexOf("."));
			System.out.println(uri);
			
			switch(uri) {
			
			case "join_move":
				System.out.println("회원가입 페이지 이동 요청 들어옴");
				response.sendRedirect("user/user_join.jsp");
				break;
				
			// 회원가입 요청
			case "join":
				System.out.println("회원가입 요청 들어옴");
				sv = new JoinService();
				sv.execute(request, response);
				break;
			
		
			case "move_loginPage":
				System.out.println("로그인 페이지 이동 요청 들어옴");
				response.sendRedirect("user/user_login.jsp");
				break;
			
			// 로그인 요청
			case "login":
				System.out.println("로그인 요청 들어옴");
				sv = new LoginService();
				sv.execute(request, response);
				break;
				
			// mypage 이동 요청 
			case "mypage":
				System.out.println("마이페이지 이동 요청 들어옴");
				response.sendRedirect("user/user_mypage.jsp");
				break;
				
			// delete 요청 
			case "delete":
				System.out.println("회원 삭제 요청 들어옴");
				sv = new DeleteService();
				sv.execute(request, response);
				break;
				
				
			
					
	}
	}

}
