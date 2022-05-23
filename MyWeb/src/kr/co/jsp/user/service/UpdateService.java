package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class UpdateService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		HttpSession session = request.getSession();

		UserVO user = (UserVO) session.getAttribute("user");
		String pw = user.getUser_pw();

		UserVO updateUser = new UserVO(id, pw, name, email, address);

		UserDAO dao = UserDAO.getInstance();
		dao.updateUser(updateUser);


		PrintWriter out;
		response.setContentType("text/html; charset=UTF-8");

		try {
			out = response.getWriter();
			String htmlcode = "<script> \r\n + " + "alert('회원정보가 수정되었습니다'); \r\n"
					+ "location.href = 'user/user_mypage.jsp'; \r\n" + "</script>";
			out.print(htmlcode);
			out.flush();
			session.setAttribute("user", dao.getUserInfo(updateUser.getUser_id()));

			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
