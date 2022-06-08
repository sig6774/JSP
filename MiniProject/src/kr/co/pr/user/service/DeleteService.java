package kr.co.pr.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.user.model.UserDAO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		response.setContentType("text/html; charset=UTF-8");
		try {		
			PrintWriter out = response.getWriter();
			String checkpw = request.getParameter("CHECKPW");
			boolean flag = UserDAO.getInstance().deleteUser(checkpw);
			System.out.println(flag);
			if (flag) {
				String htmlcode = "<script>\r\n"
						+ "alert('삭제성공'); \r\n"
						+ "location.href = '/MiniProject/move_loginPage.User';\r\n"
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;
			} else {
				String htmlcode ="<script>\r\n"
						+ "alert('비밀번호가 틀립니다. 다시 한번 확인해주세요'); \r\n"
						+ "location.href='/MiniProject/mypage.User'\r\n"
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
