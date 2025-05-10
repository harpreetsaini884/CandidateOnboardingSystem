package com.example.onboarding.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import com.example.onboarding.config.RabbitMQConfig;
import com.example.onboarding.dto.JobOfferNotification;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationProducer {
	private final RabbitTemplate rabbitTemplate;
	
	public void sendJobOfferNotification(JobOfferNotification notification) {
		rabbitTemplate.convertAndSend(
				
				 RabbitMQConfig.JOB_OFFER_EXCHANGE,
	                RabbitMQConfig.JOB_OFFER_ROUTING_KEY,
	                notification
				); 
	}
}
