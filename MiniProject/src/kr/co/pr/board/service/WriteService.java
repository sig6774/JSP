package kr.co.pr.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;

public class WriteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// request와 response를 가져올 수 있으므로 java의 클래스 안에서도 jsp 기능 수행 가능
		// form에 보내는 곳을 바꿔야함 
		String writer = request.getParameter("Bwriter");
		String title = request.getParameter("Btitle");
		String content = request.getParameter("Bcontent");
		
		System.out.println("가져온 게시글 제목 : " + title);
		BoardDAO.getInstance().regist(title, writer, content);
		System.out.println("글 등록 완료");
	}

}
