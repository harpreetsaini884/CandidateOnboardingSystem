package com.example.onboarding.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;

@Configuration
public class RabbitMQConfig {

    public static final String JOB_OFFER_QUEUE = "jobOfferQueue";
    public static final String JOB_OFFER_EXCHANGE = "jobOfferExchange";
    public static final String JOB_OFFER_ROUTING_KEY = "job.offer.notify";

    // Define Queue
    @Bean
    public Queue jobOfferQueue() {
        return new Queue(JOB_OFFER_QUEUE);
    }

    // Define Exchange
    @Bean
    public TopicExchange jobOfferExchange() {
        return new TopicExchange(JOB_OFFER_EXCHANGE);
    }

    // Define Binding
    @Bean
    public Binding jobOfferBinding() {
        return BindingBuilder.bind(jobOfferQueue()).to(jobOfferExchange()).with(JOB_OFFER_ROUTING_KEY);
    }

    // Define Message Converter for JSON
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter(); // Converts Java objects to JSON and vice versa
    }

    // Configure RabbitTemplate to use the custom message converter
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter()); // Use Jackson2JsonMessageConverter
        return rabbitTemplate;
    }
//    @Bean
//    public Queue genericQueue() {
//        return new Queue("your-queue-name", true); // durable queue
//    }
}
