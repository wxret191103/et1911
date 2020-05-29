package com.etoak;

import com.etoak.service.HelloService;
import com.etoak.service.impl.HelloServiceImpl;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by Administrator on 2020/5/29.
 */
public class CxfServer {
    public static void main(String[] args) {
        //创建JaxWsServerFactoryBean
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        //设置URL
        factory.setAddress("http://localhost:8080/hello");
        //设置发布的服务端口
        factory.setServiceClass(HelloService.class);
        //设置发布的服务实现
        factory.setServiceBean(new HelloServiceImpl());
        //创建服务 并调用start()
        Server server = factory.create();
        server.start();
        System.out.println("Server start---");


    }
}
