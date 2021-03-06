package kr.co.jsp.board.model;

import java.util.List;

import kr.co.jsp.board.commons.PageVO;

public interface IBoardDAO {

	// 글 등록 메서드 
	void regist(String writer, String title, String content);
	
	// 글 전체 목록을 가지고 오는 메서드 
	List<BoardVO> listBoard(PageVO paging);
	
	// 글 상세보기 요청을 처리할 메서드 
	BoardVO contentBoard(int Boardid);
	
	// 글 수정 요청을 처리할 메서드(제목, 내용)
	void updateBoard(String title, String content, int Boardid);
	
	// 글 삭제 요청을 처리할 메서드
	void deleteBoard(int Boardid);
	
	// 글 검색 요청을 처리할 메서드 
	List<BoardVO> searchBoard(String keyword, String category);
	
	// 조회수를 올려주는 메서드 
	void upHit(int Boardid);
	// UPDATE my_board set hit = NVL(MAX(hit),0) +1 WHERE board_id = ?;
	
	// 총 게시물 개수 조회 메서드 
	int countboards();
	
}
