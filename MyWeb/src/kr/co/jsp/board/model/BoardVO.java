package kr.co.jsp.board.model;

import java.sql.Timestamp;

public class BoardVO {
	/*
	 * CREATE TABLE my_board( board_id NUMBER PRIMARY KEY, writer VARCHAR2(30) NOT
	 * NULL, title VARCHAR2(100) NOT NULL, content VARCHAR2(2000), reg_date DATE
	 * DEFAULT sysdate, hit NUMBER DEFAULT 0 );
	 * 
	 * CREATE SEQUENCE board_seq START WITH 1 INCREMENT BY 1 MAXVALUE 1000 NOCYCLE
	 * NOCACHE;
	 */

	private int boardId;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;
	private int hit;
	
	// new마크를 띄울지 말지의 여부를 판단하는 논리 필드 추가
	private boolean newMark;
	
	public BoardVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardVO(int board_id, String writer, String title, String content, Timestamp regDate, int hit) {
		super();
		this.boardId = board_id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.hit = hit;
	}

	public int getboardId() {
		return boardId;
	}

	public void setboardId(int boardId) {
		this.boardId = boardId;
	}

	
	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public boolean isNewMark() {
		return newMark;
	}

	public void setNewMark(boolean newMark) {
		this.newMark = newMark;
	}
	
	
}
