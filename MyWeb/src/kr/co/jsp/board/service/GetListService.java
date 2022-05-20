package kr.co.jsp.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.commons.PageCreator;
import kr.co.jsp.board.commons.PageVO;
import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class GetListService implements IBoardService {
	// 글목록을 가져오는 로직 구현
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// controller에서 수행하던 작업(이동 제어제외) 모두 가져옴
		PageVO paging = new PageVO();
		
		// 사용자가 처음 게시판에 들어올 때는 페이지 선택을 하지 않기 때문에 페이지 선택을 1페이지로 게시물 개수를 10개로 지정
		// 사용자가 버튼을 눌렀을때만 밑의 2개의 코드를 실행해야함
		if (request.getParameter("page") != null) {
			paging.setPage(Integer.parseInt(request.getParameter("page")));
			// 사용자가 클릭햇을때의 버튼을 page로 설정
			paging.setCountPerPage(Integer.parseInt(request.getParameter("cpp")));
			// url에 cpp라는 이름의 값을 받아옴 
			
			System.out.println("선택한 페이지 : " + paging.getPage());
			System.out.println("게시물 수 : " + paging.getCountPerPage());
		}
		
		List<BoardVO> boardList = BoardDAO.getInstance().listBoard(paging);
		// request에 boardlist에 담으면 응답을 한 뒤 소멸하기 때문에 관리하기 좋음
		
		// 페이지 버튼 배치를 위해 PageCreator 객체 생성
		PageCreator pc = new PageCreator();
		
		// 페이징 버튼 알고리즘을 위해 PageVO 객체와 총 게시물 수를 setter메서드로 전달해야 
		// 페이징 알고리즘 구현 가능
		pc.setPaging(paging);
		pc.setBoardTotalCount(BoardDAO.getInstance().countboards());
		
		System.out.println(pc);
		// pc.toString()을 overwriting해서 알고리즘의 결과가 잘 초기화 되었는지 확인
		
		
		
		
		// boardlist에서 BoardVO를 하나씩 뽑아서 현재 날짜 기준으로 1일이 지났는지 파악
		// 이후 1일이 지나지 않았으면 newMark를 사용하는 로직 구현 
		for(BoardVO board: boardList) {
			// 운영체제의 현재 시간을 읽어서 밀리초로 리턴하는 메서드
			// currentTimeMillis은 1970년 1월 1일 자정을 기준으로 현재까지 흐른 시간을 밀리초로 리턴 
			// 
			long now = System.currentTimeMillis();
			
			// 게시물의 작성 시간을 밀리초로 읽어오기 
			long regTime = board.getRegDate().getTime();
			
			if (now - regTime < 60 * 60 * 24 * 1000) {
				// 하루의 시간보다 작으면 
				board.setNewMark(true);
			}
			// else는 굳이 쓸 필요가 없음 (boolean은 default type이 false)
			
		}
		
		request.setAttribute("bList", boardList);
		//sendRedirect를 하면 안되는 이유
		//request객체에 list를 담아서 전달하려 하는데, sendRedirect를 사용하면
		//응답이 나가면서 request 객체가 소멸해 버립니다.
//		response.sendRedirect("board/board_list.jsp"); (x)
		
		// jsp 파일에서 버튼 배치를 위해 모든 정보가 완성된 PageCreator 객체를 
		// pc라는 이름의 request 객체에 담아서 forwarding ~~~
		request.setAttribute("pc", pc);
	}

}
