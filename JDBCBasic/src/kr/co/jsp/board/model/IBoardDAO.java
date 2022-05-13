package kr.co.jsp.board.model;

import java.util.List;

public interface IBoardDAO {
	
	/*
	 interface 
	 - 클래스를 만들기 위한 틀 
	 - interface 혼자서 어떤 것을 할 수 없음(추상 메서드만 있으므로)
	 */
	
	// 게시글 등록 
	boolean insert(BoardVO vo);
	// 모든 게시물의 정보가 들어있는 객체가 들어감
	// execute~~는 true,false로 반환되므로 리턴 타입도 지정
	
	// 게시글 전체 조회 
	List<BoardVO> selectAll();
	
	// 게시글 상세 조회 
	BoardVO selectOne(int num);
	// 글 제목이 ?로 되기 때문에 매개변수로 넣음
	
	// 게시글 수정 
	boolean update(BoardVO board);
	// 글 제목, 글 내용, 글 번호가 ?로 되는데 그냥 BoardVO 객체를 통해서 넣을 수 있으므로 그냥 BoardVO객체 사용
	// execute~~는 true,false로 반환되므로 리턴 타입도 지정

	// 게시글 삭제
	boolean delete(int num);
	// 글 번호가 ?로 되기 때문에 매개변수로 넣음
}
