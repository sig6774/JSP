package kr.co.pr.board.service;

import java.util.List;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.model.BoardDAO;
import kr.co.pr.board.model.BoardVO;
import kr.co.pr.board.page.GeneratePage;
import kr.co.pr.board.page.PageVO;

public class ListService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 페이지 관련 로직 
		PageVO page = new PageVO(); 
		
		// pagenum라는 이름의 요청값이 들어왔을 때만 페이징 수행하기 위해 조건문 걸어줌 
		System.out.println("페이지 값: " +  request.getParameter("pagenum"));
		if (request.getParameter("pagenum") != null) {
			page.setPage(Integer.parseInt(request.getParameter("pagenum")));
			page.setPerPage(Integer.parseInt(request.getParameter("perpage")));
			// 요청이 발생했을 때 보낸 pagenum과 perpage란 이름의 값을 가져와서 값을 설정 
			
			System.out.println("선택 페이지 : " + page.getPage() + "페이지당 게시물 수  :" + page.getPerPage());
		}
		
		// Boardlist.jsp에서 수행하는 내용을 가져와서 사용 
		List<BoardVO> Lboard = BoardDAO.getInstance().listBoard(page);
		
		// 버튼 배치를 위해서 생성 
		GeneratePage pagebar = new GeneratePage();
		pagebar.setPage(page);
		pagebar.setTotalCount(BoardDAO.getInstance().allboard());
		
		System.out.println(pagebar);
		System.out.println("listService 실행 ");
		request.setAttribute("listBoard", Lboard);
		// listBoard라는 이름을 가진 BoardVO객체가 여러개 있는 것을 request 객체에 담아서 보냄 
		// request객체에 값을 담아서 다시 요청을 보냄 
		// request는 요청을 보내고 응답을 하면 사라지기 때문에 유지 관리에 좋음

		request.setAttribute("page", pagebar);
		// page라는 이름으로 GeneratePage객체 전해줌
	}

}
