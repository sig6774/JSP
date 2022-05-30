package kr.co.pr.board.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;

public class UpdateService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
    	try {
			
			int boardId = Integer.parseInt(request.getParameter("Bid"));
			System.out.println("수정요청 boardid 값 : " + boardId);
			String title = request.getParameter("Btitle");
			String content = request.getParameter("Bcontent");
			
			
			BoardDAO.getInstance().updateBoard(boardId, title, content);
			// DB에 값을 수정 
			System.out.println("게시판 수정완료");
			
//			request.setAttribute("upBoard", );
			// void라서 값을 보내줄 게 없음
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
