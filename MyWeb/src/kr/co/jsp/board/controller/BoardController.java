package kr.co.jsp.board.controller;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jsp.board.model.BoardDAO;
import kr.co.jsp.board.model.BoardVO;
import kr.co.jsp.board.service.ContentService;
import kr.co.jsp.board.service.DeleteService;
import kr.co.jsp.board.service.GetListService;
import kr.co.jsp.board.service.IBoardService;
import kr.co.jsp.board.service.ModifyService;
import kr.co.jsp.board.service.RegistService;
import kr.co.jsp.board.service.UpdateService;

@WebServlet("*.board")
//url이 .board로 끝나면 모두 받을 수 있음
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dp;
	private IBoardService sv;
	// 하나의 인터페이스를 만들어서 내용만 다른 클래스 객체를 생성

	public BoardController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}

	// get과 post를 편리하게 하기 위한 메소드
	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// doRequest는 doPost와 doGet에서 실행되며 doPost와 doGet은 url에 맞게 자동 실행되는 메소드
		// 매개변수로 받은 request와 response를 갱신하여 각 url에 리턴하는 방향 

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();

		// uri 정제
		uri = uri.substring(conPath.length() + 1, uri.lastIndexOf("."));

		System.out.println(uri);

		switch (uri) {

		case "write":
			System.out.println("글쓰기 페이지로 이동 요청!");
			response.sendRedirect("board/board_write.jsp");
			break;
		// board_write.jsp로 보내고 그 안에서 값을 regist.board로 다시 보냄

		case "regist":
			System.out.println("글 등록 요청이 들어옴!");
			sv = new RegistService();
			sv.execute(request, response);
			/*
			 * 왜 board_list.jsp로 바로 redirect하면 안될까?... board_list.jsp에는 데이터베이스로 부터 전체 글 목록을
			 * 가져오는 로직이 없음 jsp는 단순히 보여지는 역할만 할 뿐이라서 컨트롤러로 글 목록 요청이 다시 들어올 수 있게
			 * sendRedirect()를 사용해서 자동 목록 재요청이 들어오게 하는 것
			 */

			response.sendRedirect("/MyWeb/list.board");
			break;

		case "list":
			System.out.println("글 목록 요청이 들어옴!");
			sv = new GetListService();
			sv.execute(request, response);

			// request객체를 다음 화면까지 운반하기 위한 forward 기능을 지원하는 객체
			// forward는 연결이 끊어지지 않은 상태에서 응답을 전달
			// forward는 서버내에서 이동을 한 뒤 응답을 하기 때문에 request가 사라지지 않음
			dp = request.getRequestDispatcher("board/board_list.jsp");
			// 값을 지정한 위치에 보냄

			dp.forward(request, response);
			// 지정한 위치를 보낼 때 request와 response를 가지고 보냄

			break;

		case "content":
			System.out.println("글 상세보기 요청이 들어옴!");

			sv = new ContentService();
			sv.execute(request, response);

			dp = request.getRequestDispatcher("board/board_content.jsp");
			dp.forward(request, response);
			// 지정한 경로로 값을 가지고 보내줌
			break;
			
		case "modify":
			System.out.println("글 수정 페이지로 이동 요청이 들어옴");
			sv = new ModifyService();
			sv.execute(request, response);
			// ModiBoard라는 이름의 값이 들어가있음
			
			dp = request.getRequestDispatcher("board/board_modify.jsp");
			dp.forward(request, response);
			//request의 특성인 응답하면 사라지는 것을 방지하기 위해 사용
			//갱신한 request와 response를 해당 경로로 보냄
			break;
		
		case "update":
			System.out.println("글 수정 요청이 들어옴");
			sv = new UpdateService();
			sv.execute(request, response);
			// 메소드 실행 
			
			response.sendRedirect("/MyWeb/content.board?bId=" + request.getParameter("bId"));
			// 다시 컨트롤러에 요청을 보내야하며  상세 보기를 하기 위해서는 값도 다시 보내야함
			break;
			
		case "delete":
			System.out.println("글 삭제 요청이 들어옴");
			sv = new DeleteService();
			sv.execute(request, response);
			
			response.sendRedirect("/MyWeb/list.board");
			// 삭제를 했으면 그 내용을 list.board로 보내서 거기서 전체 출력하도록 다시 요청
				// 요청하는 이유는 jsp로 하게 되면 db연동이 안되기 때문에 모든 요청은 controller가 통제하고 있으므로 
				// sendRedirect를 통해서 list.board에 다시 요청을 해서 
				// list.board에서 요청에 응답하기 위해 연산을 진행
			
			// sendRedirect와 getRequestDispatcher 잘 모르겠음...
				// sendRedirect는 응답을 하고 다시 요청을 하고 싶을 때 사용하고 
				// forward는 request의 특징인 응답을 하면 사라지는 특징 때문에 일단 응답을 하지 않고 서버 내에서 데이터를 다른 곳으로 전달해서 그곳에서 응답을 하게 만드는 방식			
			break;
		}

	}

}
