<%@page import="kr.co.jsp.score.model.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    /*
	    파라미터 데이터(int)를 얻어오신 후 DAO에게 삭제 요청 해 주시면 됩니다.
	    (DAO의 주소값 받아와서 메서드 호출)
	    public boolean delete(???) <- DAO 클래스에 선언하세요.
	    
	    삭제가 완료되면 score_list.jsp로 이동.
	    삭제가 실패해도 score_list.jsp로 이동.
	    삭제가 성공했는지, 실패했는지의 여부를 script 태그를 이용하여
	    경고창으로 알려 주세요.
	    location.href="URL" -> 이걸로 이동시키기.
    */
    
    /*
      id를 일단 받아온 뒤 id를 가지고 where로 이용해 삭제
            삭제가 완료되면 삭제완료 
            삭제가 완료되지 않으면 삭제완료 X
    */
    
    int id = Integer.parseInt(request.getParameter("id"));
	    // ?도 get이나 post처럼 파라미터를 받아올 수 있음
	System.out.println(id);
	// id 받아올 수 있는 것 확인 
	
	//ScoreDAO dao = ScoreDAO.getInstance();
	//boolean check_delete = dao.delete(id);
	//if (check_delete == true) {
	if (ScoreDAO.getInstance().delete(id)) {
	// 삭제 연산 수행 O
    %>
<script>
    	alert("삭제 처리를 성공하였습니다.")
    	location.href = "score_list.jsp";
    </script>
<%} else {
	// 삭제 연산 수행 X%>
<script>
    	alert("삭제 처리를 실패하였습니다.")
    	location.href = "score_list.jsp";
    </script>
<% } %>