package com.example.onboarding.controller;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onboarding.dto.ForgotPasswordRequest;
import com.example.onboarding.dto.LoginRequest;
import com.example.onboarding.dto.ResetPasswordRequest;
import com.example.onboarding.entity.LoginCandidate;
import com.example.onboarding.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody LoginCandidate candidate) {
        return ResponseEntity.ok(authService.register(candidate));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authService.login(loginRequest.getUsername(), loginRequest.getPassword()));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordRequest request) throws MessagingException {
        return ResponseEntity.ok(authService.forgotPassword(request.getEmail()));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordRequest request) {
        return ResponseEntity.ok(authService.resetPassword(request.getEmail(), request.getOtp(), request.getNewPassword()));
    }
}




