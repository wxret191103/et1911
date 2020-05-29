package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloProduce {

	public static void main(String[] args) throws JMSException {
		//创建ConnectionFactory（用户名 密码 ）
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		
		Connection connection = factory.createConnection();
		connection.start();
		
		//通过connection创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//通过session创建Destination
		//如果队列不存在 那么activemq就会自动创建
		Queue helloQueue = session.createQueue("hello");
		
		//创建消息生产者
		MessageProducer producer = session.createProducer(helloQueue);
		
		//通过session创建消息
		TextMessage msg = session.createTextMessage("这是第一个Hello World消息");
		
		//使用消息发送者发送消息
		producer.send(msg);
		
		//关闭
		producer.close();
		session.close();
		connection.close();
		
		System.out.println("消息发送成功");
		
		
		
		
		

	}

}
