package com.etoak.service;

import javax.jws.WebService;

/**
 * Created by Administrator on 2020/5/29.
 * 在接口 实现类上必须加上@WebService 注解
 */
@WebService
public interface HelloService {

    String sayHello(String name);

}
