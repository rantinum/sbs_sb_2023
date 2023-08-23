package com.khj.exam.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.khj.exam.demo.vo.Rq;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class NeedLoginInterceptor implements HandlerInterceptor {
	private Rq rq;	

	public NeedLoginInterceptor(Rq rq) {
		this.rq = rq;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
		if ( !rq.isLogined() ) {
			rq.printHistoryBackJs("로그인 후 이용해주세요");
			return false;
		}
		
		System.out.println("로그인 필요!!");
		
		return HandlerInterceptor.super.preHandle(req, resp, handler);
	}
}