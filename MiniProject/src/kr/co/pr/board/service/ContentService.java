package kr.co.pr.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int boardId = Integer.parseInt(request.getParameter("bId"));
		// 제목을 클릭하면 boardid가 보내지는 방식임으로 boardid가져옴
		BoardVO board = BoardDAO.getInstance().contentBoard(boardId);
		
		request.setAttribute("board", board);
		// board라는 이름으로 BoardVO객체를 request객체에 넣어서 다시 request함
	}

}
