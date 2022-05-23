package kr.co.jsp.board.commons;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.SendResult;


//@WebFilter("*.board")
// .board로 끝나는 모든 요청에 반응
@WebFilter(filterName = "loginAuth", 
			urlPatterns = {"/write.board", "/modify.board", "/delete.board", "/myPage.user"},
			servletNames = {"basic", "board"})
// urlpattern과 servletNames 같은 것들로 filter를 줄 수 있음
public class LoginAuthFilter implements Filter {


    public LoginAuthFilter() {
    	// 필터 객체가 제거될 때 실행하는 메서드 
    	// 보통 초기화 시 생성했던 자원들을 종료하는 기능에 사용
    }
    


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 필터의 핵심 메서드 
		 - doFilter()는 클라이언트의 요청(*.board)이 있을 때마다 실행
		 - request객체와 response객체를 넘겨주기 때문에 이를 가지고 요청과 응답을 조작할 수 있음 
		 - 그리고 FilterChain을 통해 조작 이후 요청을 원래 목적지인 서블릿으로 전달할 수 있음 
		 */
		
		System.out.println("doFilter 메서드 실행");
		// 평소에 사용하는 타입은 httpServletRequest이고 매개변수로 받는 request는 ServletRequest이기 때문에
		
		// 부모타입의 ServletRequest를 자식 타입인 httpServletRequest로 끌어내리면 됨
		HttpSession session = ((HttpServletRequest) request).getSession();
		
		// 요청을 filter가 먼저 검사
		if(session.getAttribute("user") == null) {
			// 사용자의 정보가 있는 user라는 이름의 세션이 없다면 
			System.out.println("회원 권한 없음");
			((HttpServletResponse)response).sendRedirect("/MyWeb/");
			// user session이 없으면 controller로 접근하지 못하게 하고 메인 페이지로 이동하게 만듬
			return;
		}
		// 사용자 정보가 있다면 필터를 통과 
		// doFilter를 해야 controller로 넘어감
		chain.doFilter(request, response);
		
		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// 웹컨테이너(서버)가 시작될 때 필터 객체를 생성하는데 
		// 이때 객체가 생성되면서 최초 한 번 호출되는 메서드
		// 필터에서 처리 시 필요한 객체등을 초기화(JDBC관련 설정)하는데 사용 
		System.out.println("로그인 권한 필터 객체 생성");
		
	}

}
