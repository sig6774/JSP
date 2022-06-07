package kr.co.pr.user.service;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
	
	void execute(HttpServletRequest request, HttpServletRequest response);
}
