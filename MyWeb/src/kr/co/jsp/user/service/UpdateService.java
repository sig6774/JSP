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
		// session을 해당 클래스에서 사용하기 위해 

		UserVO user = (UserVO) session.getAttribute("user");
		String pw = user.getUser_pw();

		UserVO updateUser = new UserVO(id, pw, name, email, address);

		UserDAO dao = UserDAO.getInstance();
		dao.updateUser(updateUser);

		session.setAttribute("user", dao.getUserInfo(updateUser.getUser_id()));
		
		PrintWriter out;
		response.setContentType("text/html; charset=UTF-8");

		try {
			out = response.getWriter();
			String htmlcode = "<script> \r\n + " + "alert('회원정보가 수정되었습니다'); \r\n"
					+ "location.href = '/MyWeb/myPage.user'; \r\n" + "</script>";
			out.print(htmlcode);
			out.flush();
			

			return;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
