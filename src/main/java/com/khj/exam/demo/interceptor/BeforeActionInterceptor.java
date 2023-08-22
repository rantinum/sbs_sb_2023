package com.khj.exam.demo.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.khj.exam.demo.service.MemberService;
import com.khj.exam.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BeforeActionInterceptor implements HandlerInterceptor {
	@Autowired
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		Rq rq = new Rq(req, resp, memberService);
		req.setAttribute("rq", rq);
		
		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
}