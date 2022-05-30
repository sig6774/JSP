<%@page import="kr.co.pr.board.model.BoardVO"%>
<%@page import="kr.co.pr.board.model.BoardDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%-- 	<%
		int Bid = Integer.parseInt(request.getParameter("bId"));
		BoardVO board = BoardDAO.getInstance().contentBoard(Bid);
	%> --%>
<html lang="ko">
<head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">

        <title>BBS Test</title>

</head>
<body>
	<%@ include file="/include/header.jsp" %>

    
     <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 수정<small>(디자인이궁금하세요?)</small></h2>
				
					<!-- 수정한 값을 boardUpdate_con.jsp에 보내주면 됨 -->
					<c:set var = "modi" value="${ModifyBoard}"/>
                    <form action="update.Board" method = "post">
                        <div class="form-group">
                            <label>글번호</label>
                            <input type="text" class="form-control" value = "${modi.boardId}" name="Bid" readonly>
                            					<!-- value로 하면  기본값 지정 가능 -->
                        </div>
<!--                         <div class="form-group">
                            <label>글쓴이</label>
                            <input type="text" class="form-control"   name="Bwriter">
                        </div> -->
                        <div class="form-group">
                            <label>제목</label>
                            <input type="text" class="form-control"  name="Btitle" >
                        </div>
                         <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" name = "Bcontent" rows="5" ></textarea>
                        </div> 

						<!-- 현재 button으로 값이 안보내져서 input태그로 대체 -->
<!--                        구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다--> 
                        <div class="form-group">
                            <button type="submit" class="btn btn-info" onclick = "location.href = '/WebTemplete/update.Board'" >수정하기</button>
                            						<!--  boardid값만 주소에 묻혀서 보내주자 -->
                            						<!--  수정하기 누르면 수정 로직을 통해서 list로 이동  -->
                        </div> 
                        
<!--                     <input type="submit" class="btn btn-primary pull-right" value="수정">
 -->
                    </form>
                </div>
            </div>
        </div>


        </section>
    
	<%@ include file="/include/footer.jsp" %>

    
</body>
</html>