<%@page import="kr.co.jsp.board.commons.PageVO"%>
<%@page import="kr.co.jsp.board.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%
	// 테스트 데이터 생성 
		for(int i = 1; i <= 500; i++){
			String writer = "테스트문" + i;
			String title = "테스트용" + i;
			String content = i + "번째 테스트 중입니당~" ;
			BoardDAO.getInstance().regist(writer, title, content);
		}
		out.print("insert 완료!");
	%> --%>
	
	<%
		out.print("----------------------------- <br>");
		out.print("총 게시물 수 : " + BoardDAO.getInstance().countboards() + "<br>");
		out.print("----------------------------- <br>");
		
		// 끝 페이지 번호 계산 테스트
		
		PageVO paging = new PageVO();
		paging.setPage(53);
		// 총 페이지 개수 
		
		paging.setCountPerPage(10);
		// 한페이지 당 보여질 게시물 개수 
		
		int displayBtn = 10;
		// 버튼 수
		
		int endPage =(int) Math.ceil((double) paging.getPage() / displayBtn) * displayBtn;
		out.print("끝 페이지 번호 : " + endPage +"번 <br>");
		
		
		// 시작 페이지 번호 계산 테스트 
		int beginPage = (endPage - displayBtn) + 1;
		out.print("시작 페이지 번호 : " + beginPage +"번 <br>");
		
		// 이전버튼 활성화 여부 
		boolean isPrev = (beginPage == 1) ? false : true;
		out.print("이전버튼 활성화 여부 : " + isPrev +"<br>");
		
		// 다음버튼 활성화 여부
		boolean isNext = (BoardDAO.getInstance().countboards() <= (endPage * paging.getCountPerPage()) ? false:true);
		// 총 게시물의 수가 끝페이지 * 한화면에 보여줄 게시물수 보다 작으면 false
		out.print("다음버튼 활성화 여부 : " + isNext +"<br>");
		
		// 끝 페이지 보정
		if (!isNext) {
			endPage = (int) Math.ceil(BoardDAO.getInstance().countboards() / (double) paging.getCountPerPage());
		}
		out.print("보정 후 끝 페이지 번호 : " + endPage + "번");

	%>
</body>
</html>