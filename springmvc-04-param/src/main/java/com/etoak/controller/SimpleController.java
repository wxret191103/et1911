package com.etoak.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试简单的参数 <br>
 * -使用HttpServletRequest接收参数<br>
 * -使用基本数据类型和String<br>
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/simple")
public class SimpleController {
	
	/**
	 * 第一种：使用HttpServletRequest<br>
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/servlet")
	public String servlet(HttpServletRequest request){
		
		//接受前端传入的参数
		String name = request.getParameter("name");
		
		//name == null || "".equals(name)
		if(StringUtils.isEmpty(name)){
			name = "world";
		}
		
		//向request域传值
		request.setAttribute("result", "hello " + name);
		
		//webapp/pages/param.jsp
		return "param";
	}
	
	/**
	 * 第二种向request传值 ModelAndView传值
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/simple",method = {RequestMethod.GET})
	public ModelAndView simple(//
			@RequestParam(required = false,defaultValue="1") int id,//
			@RequestParam String name){
		
		System.out.println("id param -" + id);
		System.out.println("name param -" + name);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result","ModelAndView传值");
		mv.setViewName("param");
		return mv;
	}
	
	
}
