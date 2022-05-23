package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import kr.co.jsp.user.model.UserDAO;

public class LoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		// requset로부터 session을 받아와야함

		UserDAO dao = UserDAO.getInstance();
		int check = dao.userCheck(id, pw);
		// 로그인 유효성 검사
		System.out.println("로그인 유효성 검사 : " + check);

		// 알림창 만들기 위해 사용
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			PrintWriter out = response.getWriter();
			if (check == 1) {
				session.setAttribute("user", dao.getUserInfo(id));
				// 세션에 user라는 이름으로 UserVO객체를 넣어줌
				response.sendRedirect("/MyWeb/myPage.user");
			}
			else if (check == 0) {
				String htmlcode = "<script> \r\n + " + "alert('비밀번호가 틀렸습니다'); \r\n"
						+ "history.back(); \r\n" + "</script>";
				out.print(htmlcode);
				out.flush();
				
			}else {
				String htmlcode = "<script> \r\n + " + "alert('아이디가 없습니다. 회원가입해주세요'); \r\n"
						+ "location.href = '/MyWeb/loginPage.user';\r\n" + "</script>";
				out.print(htmlcode);
				out.flush();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		if (check == 1) {
//			session.setAttribute("user", dao.getUserInfo(id));
//			// 세션에 user라는 이름으로 UserVO객체를 넣어줌
//
//			try {
//				response.sendRedirect("user/user_mypage.jsp");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else if (check == 0) {
//
//			try {
//				out = response.getWriter();
//				String htmlcode = "<script> \r\n + " + "alert('비밀번호가 틀렸습니다'); \r\n"
//						+ "location.href = '/MyWeb/login.user'; \r\n" + "</script>";
//				out.print(htmlcode);
//				out.flush();
//				return;
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		} else {
//
//			try {
//				out = response.getWriter();
//				String htmlcode = "<script> \r\n + " + "alert('아이디가 없습니다. 회원가입해주세요'); \r\n"
//						+ "location.href = '/MyWeb/join.user';\r\n" + "</script>";
//				out.print(htmlcode);
//				out.flush();
//				return;
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}

}
