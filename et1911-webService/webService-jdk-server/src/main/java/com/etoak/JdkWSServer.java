package com.etoak;

import com.etoak.service.impl.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Administrator on 2020/5/29.
 */
public class JdkWSServer {
    public static void main(String[] args) {
        //两个参数
        //发布的地址（wsdl）   暴露的服务
        Endpoint.publish("http://localhost:8080/hello",new HelloServiceImpl());

        System.out.println("Server start");











    }
}
