package kr.co.pr.board.page;

public class GeneratePage {

	private PageVO page; 

	private int totalCount;

	private int beginPage;

	private int endPage;

	private boolean previousButton = false;

	private boolean nextButton = false;

	private final int buttonCount = 10;
	// 화면에 보여질 페이지 수 버튼은 통상 10개씩 보여주므로 
	// final로 지정 

	private void calPage() {
		// 끝 페이지 계산 
		this.endPage = (int) Math.ceil(page.getPage() / (double) this.buttonCount) * this.buttonCount;
		// 실수가 나올 수 있으므로 연산을 수행하는 값 중 하나는 double로 형변환 
		// 계산 이후 값은 정수형이야 함으로 다시 int로 형변환 

		// 시작 페이지 계산 
		this.beginPage = (int) Math.floor(page.getPage() / (double) page.getPerPage()) * page.getPerPage() + 1;
		
		// 이전 버튼 활성화 
		String s = Integer.toString(this.beginPage);
		int e = Integer.parseInt(s.substring(s.length()-1));
		// 인덱스값을 통해 끝자리만 추출
		if (e == 1) {
			// begintPage === 1이면 그냥 beginPage가 1일때만 이전버튼이 활성화되는데 나는 11, 21, 31 ... 이렇게 되었을 때 모두 버튼 활성화하고 싶은데
			
			this.previousButton = true;
		}

		// 다음 버튼 활성화 
		if ((this.endPage * page.getPerPage()) >= totalCount) {
			this.nextButton = true;
		} else if(!this.nextButton) {
			// 다음 버튼이 비활성화 되었다면 
			this.endPage = (int) Math.ceil(totalCount / (double) page.getPerPage());
			// 다음 버튼이 없는데 굳이 끝까지 만들어줄 필요가 없으므로 올림을 활용하여 끝+1페이지만 생성	
		}
	}

	public PageVO getPage() {
		return page;
		// 페이지 객체를 리턴 
	}

	public void setPage(PageVO page) {
		this.page = page;
	}

	public void setTotalCount(int counts) {
		this.totalCount = counts;
		// 전체 게시물을 설정해줌 
		calPage();
	}

	public int getTotalCount() {
		return totalCount;
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

	public boolean isPreviousButton() {
		return previousButton;
	}

	public void setPreviousButton(boolean previousButton) {
		this.previousButton = previousButton;
	}

	public boolean isNextButton() {
		return nextButton;
	}

	public void setNextButton(boolean nextButton) {
		this.nextButton = nextButton;
	}

	@Override
	public String toString() {
		return "page는 " + page + "전체 페이지 수는 " + totalCount + "시작 페이지는 " + beginPage
				+ "끝 페이지는 " + endPage + "이전 버튼 활성화 여부는 " + previousButton + "다음 버튼 활성화 여부는" + nextButton;
	}


}
