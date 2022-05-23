package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class ChangePWService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String oldpw = request.getParameter("old_pw");
		String newpw = request.getParameter("new_pw");
		HttpSession session = request.getSession();

		UserDAO dao = UserDAO.getInstance();
		UserVO user = (UserVO) session.getAttribute("user");
		
		int num = dao.userCheck(user.getUser_id(), oldpw);
		
		PrintWriter out;
		
		if (num == 1) {
			dao.changePassword(user.getUser_id(), newpw);
			response.setContentType("text/html; charset=UTF-8");

			try {
				out = response.getWriter();
				String htmlcode = "<script> \r\n + "
								+ "alert('비밀번호가 변경되었습니다'); \r\n"
								+ "location.href = 'user/user_mypage.jsp'; \r\n"
								+ "</script>";
				
				out.print(htmlcode);
				out.flush();
				return;
								
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		} else {
			
			response.setContentType("text/html; charset=UTF-8");

			try {
				out = response.getWriter();
				String htmlcode = "<script> \r\n + "	
						+ "alert('현재 비밀번호가 다릅니다'); \r\n"
						+ "history.back(); \r\n"
						+ "<script>";
				out.print(htmlcode);
				out.flush();
				return;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
