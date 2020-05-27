package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo extends Car {
	//级别名称
	private String levelName;
	
	//变速箱名称
	private String gearboxName;
	
	//排量
	private String outputVName;
	
	@JsonIgnore //在返回结果是不封装被此注解 注解的属性
	private List<Map<String, Integer>> priceMapList;
	
	@JsonIgnore
	private String vehicleAge;
	//传到sql
	@JsonIgnore
	private Integer startYear;
	//传到sql
	@JsonIgnore
	private Integer endYear;
}
