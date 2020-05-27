package com.etoak.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;

import com.etoak.bean.PageVo;
import com.etoak.exception.ParamException;
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
	public String add(MultipartFile file,//
			@Valid Car car,BindingResult bindingResult,//
			HttpServletRequest request) throws IllegalStateException, IOException{
		log.info("文件名称-{}",file.getOriginalFilename());
		log.info("param car - {}",car);
		
		//获取所有的校验结果
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		//校验结果不为空，则取出错误校验信息
		if(!CollectionUtils.isEmpty(allErrors)){
			StringBuffer errorBuff = new StringBuffer();
			
			for(ObjectError error : allErrors){
				String errorMsg = error.getDefaultMessage();
				errorBuff.append(errorMsg).append(";");
			}
			/*request.setAttribute("paramError",errorBuff.toString());
			return "forward:/car/toAdd";*/
			
			throw new ParamException(errorBuff.toString());
		}
		
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		String originalFilename = file.getOriginalFilename();
		String newFileName = uuid + "_" + originalFilename ;
		
		File destFile = new File("d:/upload",newFileName);
		
		file.transferTo(destFile);
		
		car.setPic("/pic/"+newFileName);
		carService.addCar(car);
		
		//重定向方式返回页面
		return "redirect:/car/toList";
	}
	
	@RequestMapping("/toList")
	public String toList(){
		return "car/list";
	}
	
	@RequestMapping("/list")
	@ResponseBody
	public PageVo<CarVo> queryList(@RequestParam(required = false,defaultValue = "1") int pageNum,
			@RequestParam(required = false,defaultValue = "8") int pageSize,CarVo carVo,String[] priceList){
		return carService.queryList(pageNum, pageSize, carVo,priceList);
	}
	
	@GetMapping("/getBrand")
	@ResponseBody
	public List<String> getBrand(){
		return carService.getAllBrand();
	}
	
	@GetMapping("/getAllSeries")
	@ResponseBody
	public List<String> getAllSeries(String brand){
		return carService.getSeriesByBrand(brand);
	}
	
	@GetMapping("/getLocation")
	@ResponseBody
	public List<String> getLocation(){
		return carService.getLocation();
	}
	
}
















