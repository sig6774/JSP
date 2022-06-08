package kr.co.pr.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.pr.user.model.UserDAO;

public class LoginService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {


		try {
			HttpSession session = request.getSession();
			PrintWriter out;
			response.setContentType("text/html; charset=UTF-8");
			out = response.getWriter();
			
			String id = request.getParameter("ID");
			String pw = request.getParameter("PW");
			
			boolean flag = UserDAO.getInstance().loginUser(id, pw);
			System.out.println("로그인 유효성 검증 : " + flag);
			if (flag) {
				session.setAttribute("userInfo", UserDAO.getInstance().userInfo(id, pw));
				String htmlcode = "<script>\r\n"
						+ "alert('로그인 성공!');\r\n"
						+ "location.href='/MiniProject/mypage.User';\r\n"
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;
			} else {
				String htmlcode = "<script>\r\n"
						+ "alert(\'로그인 실패 다시 로그인 해주세요\');\r\n"
						+ "history.back();"
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;
			}
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
