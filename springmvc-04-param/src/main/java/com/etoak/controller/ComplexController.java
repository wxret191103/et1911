package com.etoak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.etoak.bean.Student;

/**
 * 测试java bean 数组 list map
 * @author Administrator
 *
 */
@Controller
@RequestMapping("complex")
public class ComplexController {
	
	//Get请求
	@GetMapping("/bean")
	public String bean(Student student,Model model){
		 System.out.println(student);
		 model.addAttribute("result2","使用Model传值");
		 return "forward:/simple/simple?id=321";
	}
}
