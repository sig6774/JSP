package kr.co.jsp.board.model;

import java.sql.Timestamp;

public class BoardVO {
	private int boardId;
	private String writer;
	private String title;
	private String content;
	private Timestamp regDate;

	public BoardVO() {
		// TODO Auto-generated constructor stub
	}

	public BoardVO(int boardId, String writer, String title, String content, Timestamp regDate) {
		this.boardId = boardId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
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

	public int getBoardId() {
		return boardId;
	}

	
	public void setBoardId(int boardId) {
		this.boardId = boardId;
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
}
