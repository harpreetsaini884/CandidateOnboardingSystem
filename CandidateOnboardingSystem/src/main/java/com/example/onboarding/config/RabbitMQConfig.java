package com.example.onboarding.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Configuration;


public class RabbitMQConfig {
	public static final String JOB_OFFER_QUEUE="jobOfferQueue";
	public static final String JOB_OFFER_EXCHANGE="jobOfferExchange";
	public static final String JOB_OFFER_ROUTING_KEY="job.offfer.Notify";
	
	
	@Bean
	public Queue jobOfferQueue() {
		return new Queue(JOB_OFFER_QUEUE);
	}
	
	@Bean
	public TopicExchange jobOfferExchange() {
		return new TopicExchange(JOB_OFFER_EXCHANGE);
	}
	
	@Bean
	public Binding jobofferBinding() {
		return BindingBuilder.bind(jobOfferQueue()).to(jobOfferExchange()).with(JOB_OFFER_ROUTING_KEY);
	}

}
