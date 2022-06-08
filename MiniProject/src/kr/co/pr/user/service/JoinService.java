package kr.co.pr.user.service;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.user.model.UserDAO;
import kr.co.pr.user.model.UserVO;

public class JoinService implements IUserService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("ID");

		// js를 java에서 적기 위해 사용 
		PrintWriter out;
		response.setContentType("text/html; charset=UTF-8");
		
		try {
			out = response.getWriter();
			// js를 적기 위해 사용 
			
			if (UserDAO.getInstance().checkId(id)) {
				String pw = request.getParameter("PW");
				String name = request.getParameter("NAME");
				
				// telephone 문자열로 합침
				String first = request.getParameter("first");
				String second = request.getParameter("second");
				String third = request.getParameter("third");
				
				String telephone = first + second + third;
				
				String email1 = request.getParameter("email1");
				String email2 = request.getParameter("email2");
				
				String e = "";
				if (email2.equals("naver")){
					e = "@naver.com";
				} else if (email2.equals("google")){
					e = "@google.com";
				} else{
					e = "@daum.net";
				}
				
				String email = email1 + e;
				
				// 주소 
				String add1 = request.getParameter("ADDR1");
				String add2 = request.getParameter("ADDR2");
				
				String address = add1 + add2;
				
				UserVO newuser = new UserVO(
						
						id, pw, name, telephone, email, address
						);
				UserDAO.getInstance().registUser(newuser);
				// db에 유저 정보 등록 
				
				// js를 적어서 여기서 자료 이동 해줌
				String htmlcode = "<script>\r\n" 
						+ "alert(\'회원가입을 환영합니다!\')\r\n"
						+ "location.href = '/MiniProject/move_loginPage.User';\r\n" 
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;
			} else {
				String htmlcode = "<script>\r\n"
						+"alert(\'등록실패\')\r\n"
						+ "location.href = '/MiniProject/join_move.User';\r\n"
						+ "</script>";
				out.print(htmlcode);
				out.flush();
				return;
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		

}
}
