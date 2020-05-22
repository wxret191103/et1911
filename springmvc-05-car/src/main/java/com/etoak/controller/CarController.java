package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.service.CarService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/car")
@Slf4j
public class CarController {
	
	@Autowired
	CarService carService;
	
	//跳转页面
	@RequestMapping("/toAdd")
	public String toCar() {
		return "car/add";
	}	
	
	@RequestMapping("/add")
	public String add(MultipartFile file,Car car) throws IllegalStateException, IOException{
		log.info("文件名称-{}",file.getOriginalFilename());
		log.info("param car - {}",car);
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String originalFilename = file.getOriginalFilename();
		String newFileName = uuid + "_" + originalFilename ;
		
		File destFile = new File("d:/upload",newFileName);
		
		file.transferTo(destFile);
		
		car.setPic("/pic/"+newFileName);
		carService.addCar(car);
		
		//重定向方式返回页面
		return "redirect:/car/toAdd";
	}
	
	
}
















