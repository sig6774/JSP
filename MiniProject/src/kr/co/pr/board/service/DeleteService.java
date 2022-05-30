package kr.co.pr.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int boardId = Integer.parseInt(request.getParameter("bId"));
		BoardDAO.getInstance().deleteBoard(boardId);
		// 값을 보낼 것이 없으므로 끄읏~
	}

}
