package com.etoak.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.etoak.action.UserAction;
import com.etoak.service.UserService;

@Configuration //相当于xml中<beans>标签，表示这是一个spring IOC容器
public class UserConfig {
	
	@Bean("userService") //返回类型相当于bean标签的class属性 方法名相当于bean标签的id
	public UserService userService(){
		return new UserService();
	}
	
	@Bean
	public UserAction userAction(@Qualifier("userService")UserService userService){
		//return new UserAction();
		UserAction userAction = new UserAction();
		//配合@Qualifier使用
		userAction.setUserService(userService);
		return userAction;
	}
}
