package com.example.onboarding.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    // Update method signature to include candidateName
    public void sendJobOfferEmail(String to, Long candidateId, String candidateName) throws MessagingException {
        log.debug("Preparing email for: {} <{}>", candidateName, to);
        
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            String subject = "Job Offer Notification";
            String body = buildEmailBody(candidateName, candidateId);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.setFrom("harpreetoffice884@gmail.com");

            log.debug("Sending email to {}", to);
            mailSender.send(message);
            log.info("Email successfully sent to {}", to);
        } catch (MessagingException e) {
            log.error("Failed to send email to {}", to, e);
            throw e;
        }
    }


    private String buildEmailBody(String name, Long id) {
        return "<html><body>" +
               "<h2>Dear " + name + ",</h2>" +
               "<p>Congratulations! 🎉</p>" +
               "<p>You have received a job offer from our organization.</p>" +
               "<p>Candidate ID: " + id + "</p>" +
               "<p>Please log in to your <a href='https://candidate-portal.example.com'>candidate portal</a> for more details.</p>" +
               "<br/><p>Best regards,<br/>HR Team</p>" +
               "</body></html>";
    }
}