package com.example.onboarding.controller;

import com.example.onboarding.dto.CandidateDTO;
import com.example.onboarding.dto.JobOfferNotification;
import com.example.onboarding.dto.StatusUpdateRequest;
import com.example.onboarding.entity.Status;
import com.example.onboarding.service.CandidateService;
import com.example.onboarding.service.EmailService;
import com.example.onboarding.service.NotificationProducer;
import com.example.onboarding.service.impl.CandidateServiceImpl;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
@Slf4j
public class CandidateController {

    private final CandidateServiceImpl service;
    private final NotificationProducer notificationProducer; 
    private final EmailService emailService;

    @GetMapping("/send/email")
    public ResponseEntity<String> testEmail() {
        log.info("Test email endpoint triggered");
        try {
            emailService.sendJobOfferEmail("harpreet.saini.hs884@gmail.com", 1810L, "Test User");
            log.info("Test email sent successfully");
            return ResponseEntity.ok("Test email sent successfully");
        } catch (MessagingException e) {
            log.error("Failed to send test email", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send test email: " + e.getMessage());
        }
    }

    @GetMapping("/hired")
    public ResponseEntity<List<CandidateDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCandidate(id));
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<CandidateDTO> updateStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest request) {
        return ResponseEntity.ok(service.updateStatus(id, request.getStatus()));
    }

    @PostMapping
    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        return ResponseEntity.ok(service.createCandidate(candidateDTO));
    }

    @PostMapping("/{id}/notify-job-offer")
    public ResponseEntity<String> notifyJobOffer(@PathVariable Long id) {
        try {
            CandidateDTO candidate = service.getCandidate(id);
            if (candidate == null || candidate.getEmail() == null) {
                return ResponseEntity.notFound().build();
            }

            JobOfferNotification notification = JobOfferNotification.builder()
                    .candidateId(candidate.getId())
                    .name(candidate.getFirstName()+" "+candidate.getLastName())
                    .email(candidate.getEmail())
                    .build();

            notificationProducer.sendJobOfferNotification(notification);
            return ResponseEntity.ok("Notification sent to RabbitMQ for: " + candidate.getEmail());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to notify: " + e.getMessage());
        }
    }

    @PutMapping("/{id}/onboard-status")
    public ResponseEntity<CandidateDTO> updateOnboardStatus(@PathVariable Long id) {
        return ResponseEntity.ok(service.updateStatus(id, Status.ONBOARDED));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCandidateCount() {
        return ResponseEntity.ok(service.getCandidateCount());
    }
}
