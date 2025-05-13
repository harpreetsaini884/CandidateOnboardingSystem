package com.example.onboarding.listener;
import com.example.onboarding.dto.JobOfferNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.example.onboarding.config.RabbitMQConfig;

import com.example.onboarding.service.EmailService;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;

@Component
public class JobOfferListener {
	
    private final EmailService emailService;
    
    JobOfferListener(EmailService emailService){
    	this.emailService=emailService;
    }

    @RabbitListener(queues = RabbitMQConfig.JOB_OFFER_QUEUE)
    public void onMessage(JobOfferNotification notification) {
        try {
            emailService.sendJobOfferEmail(
                    notification.getEmail(),
                    notification.getCandidateId(),
                    notification.getName()
            );
            System.out.println("Email sent successfully to: " + notification.getEmail());
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
        }
    }
}
