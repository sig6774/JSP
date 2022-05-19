package kr.co.jsp.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jsp.user.model.UserDAO;
import kr.co.jsp.user.model.UserVO;

/*
 - 서블릿이란 웹 페이지를 자바 언어로만 구성하는 기법 
 즉, jsp파일을 자바 언어로만 구성
 tomact을 사용해서 jsp 파일을 자동으로 class로 변환했다면 이제는 직접 클래스를 생성해서 클래스로 요청을 처리 
 */
public class ServletBasic extends HttpServlet{
	//# servlet 클래스를 만드는 방법
	 // 1. HttpServlet 클래스 상속  
	 // 2. 생성자 선언(선택)
	 
	public ServletBasic() {
		System.out.println("페이지에 요청이 들어옴");
		System.out.println("서블릿 객체 생성!");
		// 요청이 들어오면 객체가 생성되는 것을 확인하기 위해 사용
	}
	
	// 3. HttpServlet이 제공하는 상속 메서드를 오버라이딩
	// init(), doGet(), doPost(), destroy()... 
	
	@Override
	public void init() throws ServletException {
		/*
		 - 페이지 요청이 들어왔을 때 처음 실행할 로직을 작성 
		 - init()은 컨테이너(서버 프로그램)에 의해 서블릿 객체가 생성될 때 
		 최초 1회 자동으로 호출
		 - 객체의 생성자와 비슷한 역할을 수행 
		 */
		System.out.println("init 메서드 호출 ");
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// http 통신 중 get 요청이 발생했을 때 자동으로 호출되는 메서드 
		// 매개값으로 내장객체인 request와 response가 전달되므로 객체의 메서드를 통해 파라미터 값을 가져오거나 페이지 이동 가능
		
		System.out.println("doGet메서드가 호출");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http 통신 중 post 요청이 발생했을 때 자동으로 호출되는 메서드
		// doget과 마찬가지로 내장객체인 request와 response를 매개값으로 받음
		System.out.println("doPost 메서드가 호출");
		String account = request.getParameter("account");
		// 사용자에게 입력받은 값을 가져옴 
		
		UserVO vo = UserDAO.getInstance().getUserInfo(account);
		// 입력받은 값을 바탕으로 유저 정보 찾아오는 메서드를 통해 유저 객체 찾아옴 
		
		// 자바클래스에서 세션을 사용하는 방법 
		HttpSession session = request.getSession();
		session.setAttribute("user", vo);
		// session을 user라는 이름으로 UserVO객체 값을 넣음
		
		response.sendRedirect("servlet/info.jsp");
		// 해당 페이지로 이동
	}
	
	@Override
	public void destroy() {
		// 서블릿 객체가 소멸될 때 호출되는 메서드 (객체 소멸 시 1회 자동으로 호출)
		System.out.println("destroy 메서드가 호출");
	}
}
