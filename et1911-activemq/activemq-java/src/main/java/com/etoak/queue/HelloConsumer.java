package com.etoak.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class HelloConsumer {

	public static void main(String[] args) throws JMSException {
		//创建COnnectionFactory
		ConnectionFactory factory = new ActiveMQConnectionFactory(null, null, "tcp://localhost:61616");
		
		//创建Connection
		Connection connection = factory.createConnection();
		connection.start();
		
		//创建session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		//创建Destination
		Queue helloQueue = session.createQueue("hello");
		
		//创建消费者
		MessageConsumer consumer = session.createConsumer(helloQueue);
		
		//消费消息
		TextMessage text = (TextMessage)consumer.receive();
		
		System.out.println(text.getText().toString());
		
		consumer.close();
		session.close();
		connection.close();
	}

}
