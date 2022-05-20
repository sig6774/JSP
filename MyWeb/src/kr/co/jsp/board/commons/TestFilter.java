package kr.co.jsp.board.commons;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
// 해당 필터는 모든 요청에 반응하는 필터로 Annotation 
// 필터는 클라이언트의 요청을 한번 걸러주는 역할이라고 생각
public class TestFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("필터 동작!");
		
		chain.doFilter(request, response);
	}

}
