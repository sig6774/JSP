<%@page import="kr.co.jsp.score.model.ScoreDAO"%>
<%@page import="kr.co.jsp.score.model.ScoreVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	request.setCharacterEncoding("utf-8");
    	String name = request.getParameter("name");
    	int kor = Integer.parseInt(request.getParameter("kor"));
    	int eng = Integer.parseInt(request.getParameter("eng"));
    	int math = Integer.parseInt(request.getParameter("math"));
    	// Integer.parseInt() : 문자열을 정수로 변환해주는 메소드
    	
    	int total = (kor + eng + math);
    	double avg = (total) / 3.0;
    	
    	// 데이터 포장 
    	ScoreVO vo = new ScoreVO(0, name, kor, eng, math, total, avg);
    	
    	ScoreDAO dao = ScoreDAO.getInstance();
    	// ScoreDAO의 주소값을 받아옴 (싱글톤이라서 하나의 객체만 생성하기 위해)
    	boolean flag = dao.insert(vo);
    	// vo로 저장된 객체를 줌
    	// 만약 데이터가 없으면 false로 들어감
    	
    	if (flag) {
    		response.sendRedirect("insert_success.jsp");
    	} else {
    		response.sendRedirect("insert_form.jsp");
    	}
    %>
    