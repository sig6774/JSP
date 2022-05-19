package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// content에 대해 controller가 하는 잡일을 모두 가져옴
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		BoardVO board = BoardDAO.getInstance().contentBoard(bId);
//		contentBoard에서 값을 boardvo객체를 받아옴
		
		request.setAttribute("content", board);
	}

}
