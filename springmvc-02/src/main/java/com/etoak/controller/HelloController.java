package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//获取参数 
		String name = request.getParameter("name");
		
		//调用Service服务层     暂不处理
		
		//返回页面
		ModelAndView mv = new ModelAndView();
		//webapp/pages/hello.jsp
		mv.setViewName("hello");
		//向request域传值，相当于request.setAttribute();
		mv.addObject("result","hello " + name);
		
		
		return mv;
	}

}
