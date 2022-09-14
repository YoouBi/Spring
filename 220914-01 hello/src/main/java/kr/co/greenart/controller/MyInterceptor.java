package kr.co.greenart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MyInterceptor extends HandlerInterceptorAdapter {
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	
	// 사용자의 요청을 처리하기 전
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("--- 1. 핸들러가 처리 전 ---");
		
		HttpSession session = request.getSession(false);
		if(session != null) { // .getSession을 할 때 세션이 없으면 null값을 줌
			session.removeAttribute("burn");
		}
		request.setAttribute("burn", "요청 객체에 새로운 어트리뷰트 생성");
		return true; // 로그인 필터처럼 다음 흐름으로 넘어가지 않게끔 만드려면 false값을 주면 됨
	}
	
	// 요청을 처리한 후지만 뷰가 만들어지기 전
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("--- 3. 핸들러 처리 후, 뷰 생성 전 ---");
		
		String value = (String) request.getAttribute("burn");
		value += ". 핸들러 처리 후 어트리뷰트 변경";
		request.setAttribute("burn", value);
	}
	
	// 뷰가 만들어진 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("--- 5. 뷰 생성 후 ---");
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("burn");
	}
	// 뷰가 만들어지기 전과 후는 확실히 다르다
}