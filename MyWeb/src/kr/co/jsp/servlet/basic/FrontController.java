package kr.co.jsp.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("*.do")
// annotation(그냥 기능이 있는 주석이라고 생각)
// web.xml에서 등록했던 것을 자동으로 해주는 기능
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}


	public void destroy() {
		// TODO Auto-generated method stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget메서드 호출");
		System.out.println("요청 URL : " + request.getRequestURI());
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		// 현재의 contextroot인 /MyWeb이 옴
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		// /MyWeb/write.do에서 write만 골라내기 위해서 작성
		System.out.println("정제된 uri : " + uri);

		
		
		if (uri.equals("/MyWeb/write.do")) {
			System.out.println("글 작성 요청이 들어옴 ");
		}
		else if (uri.equals("/MyWeb/list.do")) {
			System.out.println("글 목록 요청이 들어옴");
		}
	}
	// 이렇게 uri를 통해서 하나의 컨트롤러에서 요청을 구분할 수 있음


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
