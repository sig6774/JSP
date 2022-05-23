package kr.co.jsp.user.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

public class JoinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		// request객체 안에 있는 값을 가져옴

		System.out.println("회원가입 요청 들어옴");

		UserDAO dao = UserDAO.getInstance();
		UserVO newUser = null;
		PrintWriter out;
		response.setContentType("text/html; charset=UTF-8");

		try {
			out = response.getWriter();

			if (dao.confirmID(id)) {

				String htmlcode = "<script> \r\n + " + "alert('아이디가 중복되었습니다.'); \r\n"
				// alert을 하면 응답을 완료해서 응답이 커밋된 후 sendredirect 할 수 없음
//						+ "location.href = '/MyWeb/join.user;' \r\n"
						+ "history.back(); \r\n"
						// 그냥 다시 돌아가기로 만듬
						+ "</script>";
				out.print(htmlcode);

				out.flush();

				return;

			} else {
				String pw = request.getParameter("pw");
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				newUser = new UserVO(id, pw, name, email, address);
				dao.insertUser(newUser);
				String htmlcode = "<script>\r\n" 
						+ "alert(\'회원가입을 환영합니다!\')\r\n"
						+ "location.href = '/MyWeb/loginPage.user';\r\n" 
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
