package com.etoak.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
	private Integer id;
	
	@NotNull(message="brand不能为空")
	@NotEmpty(message="brand不能为空")
	private String brand;
	
	@NotNull(message="车系不能为空")
	@NotEmpty(message="车系不能为空")
	private String series;
	
	@NotNull(message="价格不能为空")
	@Min(value=1,message="价格不能少于1")
	@Max(value=100,message="价格最大是100")
	private Integer price;
	
	//上牌时间
	private String licensingTime;
	//级别
	private String level;
	private String gearbox;
	private String outputV;
	private Integer mileage;
	private String location;
	private String pic;
	
	//概述
	@Size(min=6,max=12,message="概述只能6-12个字符之间")
	private String summary;
	
	private String createTime;
}
