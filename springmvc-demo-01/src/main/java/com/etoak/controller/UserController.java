package com.etoak.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etoak.bean.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private List<User> userList = new ArrayList<User>();
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	
	@RequestMapping("/add")
	@ResponseBody
	public String addUser(@RequestBody User user){
		userList.add(user);
		System.out.println(userList);
		return "add success";
	}
	
	@RequestMapping("/listAll")
	@ResponseBody
	public List<User> queryList(){
		return userList;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(@RequestBody User user){
		for(User u : userList){
			if(user.getId() == u.getId()){
				u.setName(user.getName());
				u.setHobbyList(user.getHobbyList());
			}
		}
		return "update success";
	}
	
	@RequestMapping("/del")
	@ResponseBody
	public String del(@RequestParam("id") int id){
		Iterator<User> car = userList.iterator();
		while(car.hasNext()){
			User u = car.next();
			if(id == u.getId()){
				car.remove();
			}
		}
		
		return "delete success";
	}
	
}

