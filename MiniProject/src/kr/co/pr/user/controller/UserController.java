package kr.co.pr.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.board.service.IBoardService;


@WebServlet("*.User")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RequestDispatcher dp;
	private IBoardService sv;
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("서블릿 객체 생성 ");
	}

	public void destroy() {
		System.out.println("서블릿 객체 사라짐");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			String uri = request.getRequestURI();
			// 요청했을 때의 uri 값을 가져옴 
			String path = request.getContextPath();
			uri = uri.substring(path.length() + 1 , uri.lastIndexOf("."));
			System.out.println(uri);
			
			switch(uri) {
			
			case "":
				
					
	}
	}

}
