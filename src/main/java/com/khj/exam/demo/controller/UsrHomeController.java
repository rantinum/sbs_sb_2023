package com.khj.exam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsrHomeController {
	@RequestMapping("/usr/home/main")
	@ResponseBody
	public String getString() {
		return "메인 입니다";
	}
	
	@RequestMapping("/")
	public String showRoot() {
		return "usr/home/main";
	}
}