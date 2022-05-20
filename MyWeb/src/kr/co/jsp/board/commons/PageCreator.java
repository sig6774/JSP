package kr.co.jsp.board.commons;

public class PageCreator {

	/*
	 * 페이징을 하기 위해서 필요한 것들 - 페이지 번호와 한 페이지당 들어갈 게시물의 개수를 가지고 있는 객체
	 */
	private PageVO paging;

	private int BoardTotalCount;
	// 총 게시물 개수

	private int beginPage;
	// 시작 페이지 번호

	private int endPage;
	// 끝 페이지 번호

	private boolean prev;
	// 이전 버튼 활성화 여부

	private boolean next;
	// 다음 버튼 활성화 여부

	// 한 화면에 보여질 페이지 버튼 수
	private final int displayBtn = 10;
	// final로 지정했으니 수정불가

	
	// 페이징 알고리즘을 수행할 메서드 선언
	private void calcDataOfPage() {
		// 보정 전 끝 페이지
		this.endPage = (int) (Math.ceil(paging.getPage() / (double) displayBtn)) * this.displayBtn;
		System.out.println(paging);
		System.out.println(endPage);
		
		
		// 시작 페이지 번호
		this.beginPage = (this.endPage - this.displayBtn + 1);

		// 현재 시작 페이지가 1이라면 이전 버튼 비활성화 여부 판단
		this.prev = (this.beginPage == 1) ? false : true;

		// 마지막 페이지인지 여부 확인 후 다음 버튼 비활성 여부 판단
		this.next = ((this.BoardTotalCount <= (this.endPage * paging.getCountPerPage())) ? false : true);
		
		
		// 다음 버튼 비활성화라면 끝 페이지 보정
		if (!this.next) {
			this.endPage = (int) Math.ceil(this.BoardTotalCount / (double) paging.getCountPerPage());
		}

	}

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getBoardTotalCount() {
		return BoardTotalCount;
	}

	public void setBoardTotalCount(int BoardTotalCount) {
		this.BoardTotalCount = BoardTotalCount;
		// service 클래스가 이 메서드를 통해 총 게시물의 개수를 전달할 때
		// 밑의 calcDataOfPage()가 가동될 수 있도록 하는 것
		calcDataOfPage();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", BoardTotalCount=" + BoardTotalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", displayBtn=" + displayBtn + "]";
	}

	
}
