<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    <!-- html형식은 다른 곳에도 있을 것이므로 지움 -->
    <%! int visit; %>
    <!-- 값을 누적시키기 위해 declaration 사용 -->
    
    <% visit++; %>
    
    <h2> 방문자 수 : <%= visit %> 명 </h2>
    <!-- Header -->
    
    