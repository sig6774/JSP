package kr.co.pr.board.model;

import java.util.List;

public interface IBoardDAO {
	
	void regist(String title, String writer, String content);
	
	List<BoardVO> listBoard();
	// 일단은 page는 하지말고 완성된 후 진행 
	
	BoardVO contentBoard(int boardId);
	
	void updateBoard(int boardId, String title, String content);
	
	void deleteBoard(int boardId);
	
	
}
