package com.example.onboarding.service;

import com.example.onboarding.config.RabbitMQConfig;
import com.example.onboarding.dto.JobOfferNotification;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    private final RabbitTemplate rabbitTemplate;

    public void sendJobOfferNotification(JobOfferNotification notification) {
    	System.out.println("Sending job offer notification to RabbitMQ...");
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.JOB_OFFER_EXCHANGE,
                RabbitMQConfig.JOB_OFFER_ROUTING_KEY,
                notification
        );
    }
}
