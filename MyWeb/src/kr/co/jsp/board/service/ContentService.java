package kr.co.jsp.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;

public class ContentService implements IBoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// content에 대해 controller가 하는 잡일을 모두 가져옴
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		/*
	       # 쿠키로 조회수를 컨트롤 해 보자.
	       1. 사용자가 글 제목을 눌러서 상세보기 요청을 보낼 때 
	       글 번호로 된 쿠키를 하나 만들어 줄 겁니다. (String)
	       쿠키 이름과 쿠키에 저장할 값을 모두 글 번호로 만들어 주겠습니다.
	       
	       2. 요청을 보낼 때 같이 넘어온 쿠키 중에, 
	        현재 글 번호와 일치하는 쿠키가 존재한다면 조회수를 올려주지 않을 겁니다.
	        현재 글 번호와 일치하는 쿠키가 없다면 조회수를 올려주도록 하겠습니다.
	        쿠키의 수명은 15초로 설정하겠습니다.
	       */
		
		
		String boardId = request.getParameter("bId");
		
		// 방법1
//		Cookie cookie = new Cookie(boardId, boardId);
//		// 쿠키 만들기(String만 들어감) 
//		
////		String dr = (String) boardId; \
//		// 되네 
//		
//		cookie.setMaxAge(15);
//		response.addCookie(cookie);
		// 쿠키 추가
		
		
		
		Cookie[] hitcookie = request.getCookies();
		
		
		
		if (hitcookie.length > 0) {
			// 쿠키 배열에 쿠키가 있다면 
			boolean flag = false;
			for (Cookie c : hitcookie) {
				
				if (c.getName().equals(boardId)) {
					flag = true;
					break;
					// 쿠키의 이름이 boardId와 같다면 즉시 반복문 종료 
				}
			}
			if (!flag) {
				// flag가 false니깐 이름이 같은 쿠키가 없다는 뜻이므로 조회수 올림
				BoardDAO.getInstance().upHit(bId);
				
				// 방법2
				// 쿠키가 존재하지 않는다면 쿠키 생성
				Cookie cookie = new Cookie(boardId, boardId);
				cookie.setMaxAge(15);
				response.addCookie(cookie);

			}
		}
		// 이거 다시 보기
		
//					BoardDAO.getInstance().upHit(bId);
//					// 조회수 증가
		BoardVO board = BoardDAO.getInstance().contentBoard(bId);
		
//		contentBoard에서 값을 boardvo객체를 받아옴
		
		request.setAttribute("content", board);
	}
}
