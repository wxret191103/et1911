package com.etoak.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.Student;

/**
 * 测试java bean 数组 list map
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/complex")
public class ComplexController {
	
	/**
	 * 第三种接收参数的方式：使用java bean <BR>
	 * 第三种向request域传值的方式：使用Model对象
	 * 
	 * @param student
	 * @param model
	 * @return
	 */
	// Get请求： @RequestMapping的method属性指定
	// Get请求：@GetMapping
	@GetMapping("/bean")
	public String bean(Student student,Model model){
		 System.out.println(student);
		 model.addAttribute("result2","使用Model传值");
		 return "forward:/simple/simple?id=321";
	}
	
	@PostMapping("/array")
	public String array(String[] hobby,ModelMap modelMap){
		for(String hobbyStr : hobby){
			System.out.println("hobby - " + hobbyStr);
		}
		modelMap.addAttribute("result","使用ModelMap传参");
		return "param";
	}
	
	
	@PostMapping("/list")
	public String list(Student stu,Map<String,Object> map){
		
		List<String> hobbyList = stu.getHobbyList();
		//不为空遍历
		if(!CollectionUtils.isEmpty(hobbyList)){
			hobbyList.forEach(x -> System.out.println(x));
		}
		
		map.put("result2", "使用map传值");
		return "param";
	}
	
	@RequestMapping(value = "/map",produces={"text/plain"})
	@ResponseBody //可以返回json，xml，纯文本
	public String map(Student stu){
		System.out.println(stu.getStuMap());
		return "success";
	}
	
	
		
}
