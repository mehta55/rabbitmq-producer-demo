package com.nagarro.RabbitMQProdDemo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQProdConfig {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.routingKey}")
	private String routingKey;
	
	@Bean
	Queue queue() {
		return new Queue(queue);
	}

	@Bean
	DirectExchange exchange() {
		return new DirectExchange(exchange);
	}
	
	@Bean
	Binding binding() {
		return BindingBuilder.bind(queue()).to(exchange()).with(routingKey);
	}
	
}
