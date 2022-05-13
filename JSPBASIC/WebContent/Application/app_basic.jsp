<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <%
    	int count = 0;
    	
    	
    	if (application.getAttribute("visit") != null){
    		count = (int) application.getAttribute("visit");
    		// 값을 누적시키기 위해서 사용
    	}
    	count++;
    	
    	application.setAttribute("visit", count);
    	// 어플리케이션이라는 내장 객체에 visit라는 이름으로 count 저장
    %>