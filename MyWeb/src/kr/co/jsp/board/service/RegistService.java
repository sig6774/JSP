package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;

public class RegistService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// controller에서 작성한 값을 받아오는 부분을 여기서 실행 
		
		System.out.println("글 등록 요청이 들어옴!");
		String writer = request.getParameter("bWriter");
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		System.out.println("title명" + title);
		BoardDAO.getInstance().regist(writer, title, content);
		//.board 확장자를 가지고 이름이 list인 곳으로 보냄
		// 요청이 다시 들어가야 db에서 데이터를 가져와서 화면에 출력할 수 있음
	}

}
