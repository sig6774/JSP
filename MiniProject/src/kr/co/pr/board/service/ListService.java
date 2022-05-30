package kr.co.pr.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;

public class ListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// Boardlist.jsp에서 수행하는 내용을 가져와서 사용 
		List<BoardVO> Lboard = BoardDAO.getInstance().listBoard();
		
		System.out.println("listService 실행 ");
		request.setAttribute("listBoard", Lboard);

		// listBoard라는 이름을 가진 BoardVO객체가 여러개 있는 것을 request 객체에 담아서 보냄 
		// request객체에 값을 담아서 다시 요청을 보냄 
		// request는 요청을 보내고 응답을 하면 사라지기 때문에 유지 관리에 좋음
	}

}
