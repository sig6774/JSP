package kr.co.pr.board.page;

public class PageVO {
	
	private int page;
	private int PerPage;
	// 현재 페이지와 페이지당 보여질 게시물 수
	
	public PageVO() {
		// PageVO객체를 불러올 때 초기값 미리 지정 
		this.page = 1;
		// 시작 페이지
		this.PerPage = 10;
		// 한페이지당 보여질 게시물 수 
	}
	
	public PageVO(int page, int perPage) {
		super();
		this.page = page;
		this.PerPage = perPage;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPage() {
		return this.PerPage;
	}

	public void setPerPage(int perPage) {
		this.PerPage = perPage;
	}
	
	// page와 페이지별 게시물 수 보기 위해 사용
	@Override
	public String toString() {
		return "page는" + this.page + ", 페이지별 게시물 수는 : " + this.PerPage; 
	}
	
}
