package com.etoak.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;


public interface CarMapper {
	int addCar(Car car);
	
	List<CarVo> queryList(CarVo carVo);
	
	List<String> getAllBrand();
	/**
	 * 根据品牌查询车系  品牌可能为空
	 * @param brand
	 * @return
	 */
	List<String> getSeriesByBrand(@Param("brand") String brand);

	List<String> getLocation();

	

}
