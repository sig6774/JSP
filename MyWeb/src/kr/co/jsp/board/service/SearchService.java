package kr.co.jsp.board.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class SearchService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String keyword = request.getParameter("search");
		String category = request.getParameter("category");

		List<BoardVO> boards = BoardDAO.getInstance().searchBoard(keyword, category);

		// 방법1
//		if (boards.size() == 0) {
//			// 검색 결과가 없으면
//			request.setAttribute("searchFail", true);
//		} else {
//		request.setAttribute("bList", boards);
		// board_list.jsp에 값을 보내줄꺼라서 이름을 같게 해야 화면에 출력됨
		// board_list.jsp를 건드리지 않고 여기서만 이름을 같게 해주면 동일한 결과 출력

		// 방법2
		// 자바 클래스에서 html이나 js문법을 사용하는 방법 : PrintWriter 객체를 사용
		if (boards.size() == 0) {
			response.setContentType("text/html; charset=UTF-8");
			try {
				PrintWriter out = response.getWriter();
				// 원하는 html, js 코드를 문자열 형태로 작성 
				
				String htmlCode = "<script> \r\n + "
								+ "alert('검색 결과가 없습니다.'); \r\n"
								+ "location.href = '/MyWeb/list.board;' \r\n"
								+ "</script>";
				out.print(htmlCode); // 버퍼에 작성한 문자열을 저장 
				
				out.flush(); // 버퍼에 저장되어 있는 내용을 클라이언트로 전송하고 버퍼를 비움
				
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} 
		
		// return 으로 메소드를 강제종료시키면 else안써도 됨
		request.setAttribute("bList", boards);
		// board_list.jsp에 값을 보내줄꺼라서 이름을 같게 해야 화면에 출력됨
		// board_list.jsp를 건드리지 않고 여기서만 이름을 같게 해주면 동일한 결과 출력

		

	}
}
