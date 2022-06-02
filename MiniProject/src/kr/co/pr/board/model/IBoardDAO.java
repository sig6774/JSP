package kr.co.pr.board.model;

import java.util.List;

import kr.co.pr.board.page.PageVO;

public interface IBoardDAO {
	
	void regist(String title, String writer, String content);
	
	List<BoardVO> listBoard(PageVO page);
	// 일단은 page는 하지말고 완성된 후 진행 
	
	BoardVO contentBoard(int boardId);
	
	void updateBoard(int boardId, String title, String content);
	
	void deleteBoard(int boardId);
	
	int allboard();
	// 전체 게시물 수 리턴 
	
	
}
