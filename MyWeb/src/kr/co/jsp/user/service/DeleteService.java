package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class DeleteService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String checkPw = request.getParameter("check_pw");

		UserDAO dao = UserDAO.getInstance();
		// 주소값 가지고 오기

		HttpSession session = request.getSession();

		// session가지고 오기
		UserVO user = (UserVO) session.getAttribute("user");

		int check = dao.userCheck(user.getUser_id(), checkPw);
		// id와 pw를 통해 유효성 검사
		PrintWriter out;
		response.setContentType("text/html; charset=UTF-8");

		try {
			out = response.getWriter();

			if (check == 1) {
				// pw가 같다면

				dao.deleteUser(user.getUser_id());
				// 삭제 연산 진행

				session.invalidate();
				// 세션 정보 삭제

				String htmlcode = "<script>\r\n" 
						+ "alert(\'삭제가 완료되었습니다.\');\r\n"
						+ "location.href='/MyWeb/';\r\n" 
						+ "</script>";

				out.print(htmlcode);
				out.flush();
			} else {
				// pw가 같지 않다면

				String htmlcode = "<script>\r\n"
								+ "alert('삭제가 완료되지 않았습니다. 비밀번호를 확인하세요.\');\r\n"
								+ "location.href='/MyWeb/myPage.user';\r\n" 
								+ "</script>";

				out.print(htmlcode);
				out.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
