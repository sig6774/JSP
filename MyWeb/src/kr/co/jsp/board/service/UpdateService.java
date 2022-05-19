package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		String title = request.getParameter("bTitle");
		String content = request.getParameter("bContent");
		BoardDAO.getInstance().updateBoard(title, content, bId);
		// board_modify.jsp에서 값을 받아와서 update
	}

}
