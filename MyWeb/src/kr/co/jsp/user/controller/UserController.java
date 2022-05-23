package kr.co.jsp.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.service.RegistService;
import kr.co.jsp.user.service.ChangePWService;
import kr.co.jsp.user.service.DeleteService;
import kr.co.jsp.user.service.IUserService;
import kr.co.jsp.user.service.JoinService;
import kr.co.jsp.user.service.LoginService;
import kr.co.jsp.user.service.UpdateService;


@WebServlet("*.user")
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
		uri = uri.substring(request.getContextPath().length() + 1, uri.lastIndexOf("."));
		// uri 정제 
		
		System.out.println("uri 확인 : " + uri);
		
		switch(uri) {
		case "joinPage":
			System.out.println("회원가입 페이지로 이동 요청");
			response.sendRedirect("user/user_join.jsp");
			break;
			
		case "join" :
			System.out.println("회원 가입 요청이 들어옴");
			sv = new JoinService();
			sv.execute(request, response);
			// service에서 응답을 모두 끝냈으니 controller에서는 응답을 할 필요가 없음
			break;
			
		case "loginPage":
			System.out.println("로그인 페이지로 이동 요청");
			response.sendRedirect("user/user_login.jsp");
			break;
			
		case "login":
			System.out.println("로그인 요청");
			sv = new LoginService();
			sv.execute(request, response);
			// service쪽에서 응답이 모두 나갔으므로 따로 지정할 게 없음
			break;
		
		case "myPage":
			System.out.println("마이페이지로 이동 요청");
			response.sendRedirect("user/user_mypage.jsp");
			break;
			
		case "pwPage":
			System.out.println("비밀번호 변경 페이지로 이동 요청");
			response.sendRedirect("user/user_change_pw.jsp");
			break;
		
		case "ChangePWService":
			System.out.println("비밀번호 변경 요청");
			sv = new ChangePWService();
			sv.execute(request, response);;
			// service에서 요청을 모두 처리했기 때문에 controller에서 따로 처리할 필요 없음
			break;
			
		case "modPage":
			System.out.println("회원정보 변경 페이지로 이동 요청");
			response.sendRedirect("user/user_update.jsp");
			break;
			
		case "UpdateService":
			System.out.println("회원 정보 수정 요청");
			sv = new UpdateService();
			sv.execute(request, response);
			// service에서 요청을 모두 처리했기 때문에 controller에서 따로 처리할 필요 없음
			break;
		
		case "delPage":
			System.out.println("탈퇴 페이지로 이동 요청");
			response.sendRedirect("user/user_delete.jsp");
			break;
		
		case "DeleteService":
			System.out.println("회원 탈퇴 요청");
			sv = new DeleteService();
			sv.execute(request, response);
			// service에서 요청을 모두 처리했기 때문에 controller에서 따로 처리할 필요 없음
			break;
		}
		
	}

}
