package com.nagarro.RabbitMQProdDemo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQProducer {
	
	@Autowired
	private AmqpTemplate rabbitTemplate;

	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routingKey}")
	private String routingKey;
	
	public void produce(String message) {
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
	
}
