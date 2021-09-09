package com.nagarro.RabbitMQProdDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class RabbitMqDemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(RabbitMqDemoApplication.class, args);
		System.out.println("Started..");
		
		RabbitMQProducer producer = context.getBean(RabbitMQProducer.class);
		producer.produce("Hello world 1");
		producer.produce("Hello world 2");
		producer.produce("Hello world 3");
		
		System.out.println("Stopped..");
	}

}
