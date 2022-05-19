package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class ModifyService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println(request.getParameter("bId"));
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BoardVO board = BoardDAO.getInstance().contentBoard(bId);
		// 글번호를 바탕으로 기존에 저장되어 있는 board 불러오기
		
		request.setAttribute("ModiBoard", board);
		System.out.println("modify service 동작 " + board.getboardId());
		
		

	}

}
