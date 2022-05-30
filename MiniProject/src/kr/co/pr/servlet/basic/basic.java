package kr.co.pr.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.pr.user.model.UserDAO;
import kr.co.pr.user.model.UserVO;


//@WebServlet("/basic")
// 아마도 이거는 별 상관없을 것 같은데 그냥 적어보기 (연습 느낌)
public class basic extends HttpServlet {
       

    public basic() {
    	System.out.println("페이지에 요청이 들어와성 servlet 객체 생성 ");
    }

    @Override
	public void init() throws ServletException {
    	// httpservlet의 내용을 override
    	// 서블릿 객체가 생성될 때 자동 호출 
    	System.out.println("init 메서드 호출");
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// get요청이 들어왔을 때 자동 호출 
    	System.out.println("doGet메서드 호출 ");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// post 요청이 발생했을 때 자동 호출
    	System.out.println("doPost메서드 호출 ");
    }
    
    
 
    @Override
	public void destroy() {
    	System.out.println("destroy 메서드 호출");
	}

}
