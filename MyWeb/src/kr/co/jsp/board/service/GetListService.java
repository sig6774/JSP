package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// controller에서 수행하던 작업(이동 제어제외) 모두 가져옴
		
		List<BoardVO> boardList = BoardDAO.getInstance().listBoard();
		// request에 boardlist에 담으면 응답을 한 뒤 소멸하기 때문에 관리하기 좋음
		request.setAttribute("bList", boardList);
		//sendRedirect를 하면 안되는 이유
		//request객체에 list를 담아서 전달하려 하는데, sendRedirect를 사용하면
		//응답이 나가면서 request 객체가 소멸해 버립니다.
//		response.sendRedirect("board/board_list.jsp"); (x)
	}

}
