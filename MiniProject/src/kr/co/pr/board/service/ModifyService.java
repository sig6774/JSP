package kr.co.pr.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;

public class ModifyService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bId"));
		BoardVO board = BoardDAO.getInstance().contentBoard(bid);
		
		// 입력 받은 board를 보내야함으로 request객체에 실어서 보냄 
		request.setAttribute("ModifyBoard", board);
		
	}

}
