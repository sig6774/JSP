package kr.co.pr.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.service.ContentService;
import kr.co.pr.board.service.DeleteService;
import kr.co.pr.board.service.IBoardService;
import kr.co.pr.board.service.ListService;
import kr.co.pr.board.service.ModifyService;
import kr.co.pr.board.service.UpdateService;
import kr.co.pr.board.service.WriteService;

// .Board로 시작하는 모든 것을 여기서 처리
@WebServlet("*.Board")
public class BoardController1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RequestDispatcher dp; 
	private IBoardService sv;
    public BoardController1() {
        super();
    }


	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 객체 생성 ");
	}


	public void destroy() {
		System.out.println("서블릿 객체 사라짐");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
		
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String uri = request.getRequestURI();
		// URI값 가져옴 
		String PATH = request.getContextPath();
		
		uri = uri.substring(PATH.length()+1, uri.lastIndexOf("."));
		System.out.println(uri);
		
		switch (uri) {
		
		case "write":
			System.out.println("글 등록 페이지로 이동 요청");
			response.sendRedirect("Board/Boardwrite.jsp");
			break;
			
		case "regist" : 
			// 정제된 uri가 write일 때 로직 진행 
			System.out.println("글 등록 요청");
			sv = new WriteService();
			sv.execute(request, response);
			// writeService()에서 실행 
			
			response.sendRedirect("/WebTemplete/Boardlist.Board");
			// 글쓰기에서 글등록하면 forwarding오류남 
			// 물어보기
			break;
		
		case "Boardlist":
			System.out.println("글 목록 페이지 이동 ");
			
			sv = new ListService();
			sv.execute(request, response);
			// board들이 저장된 객체가 request를 통해서 다시 돌아옴 
			
			dp = request.getRequestDispatcher("Board/Boardlist.jsp");
			dp.forward(request, response);
			// 값을 지정한 위치에 보냄 
			break;
			
		case "content":
			System.out.println("글 상세 보기 요청 ");
			sv = new ContentService();
			sv.execute(request,response);
			dp = request.getRequestDispatcher("Board/BoardContent.jsp");
			dp.forward(request, response);
			
			break;
			
		case "modify":
			System.out.println("글 수정창으로 이동 요청");
			sv = new ModifyService();
			sv.execute(request, response);
			
			dp = request.getRequestDispatcher("Board/BoardModify.jsp");
			dp.forward(request, response);
			break;
			// board객체를 보내서 그 값을 바탕으로 수정 진행 
			
			// update로 모두 바꿀려고 했는데 update 값을 입력할 수 있는 창이 안나옴
			// 우선 수정할 수 있는 창을 띄우고 그 값을 입력받고 update 진행해야겠다 
		case "update":
			System.out.println("글 수정 요청");
			sv = new UpdateService();
			sv.execute(request, response);
			response.sendRedirect("/WebTemplete/Boardlist.Board");

			
			break;
			
		case "delete":
			System.out.println("삭제 요청 ");
			sv = new DeleteService();
			sv.execute(request, response);
			
			response.sendRedirect("/WebTemplete/Boardlist.Board");
			break;
			
			
		
			
		}
	}
	
	
	
	
	

}
