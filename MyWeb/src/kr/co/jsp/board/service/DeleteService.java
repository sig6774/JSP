package kr.co.jsp.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;

public class DeleteService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int bId = Integer.parseInt(request.getParameter("bId"));
		// 요청에서 준 값을 bId로 저장
		BoardDAO.getInstance().deleteBoard(bId);
		// 받은 값을 바탕으로 DAO에서 삭제 연산 수행 

	}

}
