package kr.co.pr.board.model;

import java.sql.Timestamp;

public class BoardVO {

	/*
	 * CREATE table pr_board ( board_id number(3) primary key, title varchar2(30)
	 * not null, writer varchar2(30) not null, reg_date date default sysdate );
	 * 
	 * CREATE SEQUENCE pr_board_id_seq START WITH 1 INCREMENT BY 1 MAXVALUE 1000
	 * NOCACHE NOCYCLE;
	 */
	private int boardId;
	private String title;
	private String writer;
	private String content;
	private Timestamp regDate;
	
	public BoardVO(int boardId, String title, String writer, String content, Timestamp regDate) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.regDate = regDate;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public BoardVO() {
		// TODO Auto-generated constructor stub
	}


	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
}
