

package com.example.onboarding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CandidateNotFoundException.class)
    public ResponseEntity<?> handleNotFound(CandidateNotFoundException ex) {
        return new ResponseEntity<>(
                Map.of(
                        "timestamp", LocalDateTime.now().toString(),
                        "status", 404,
                        "error", "Candidate Not Found",
                        "message", ex.getMessage(),
                        "path", "/api/candidates/{id}"
                ), HttpStatus.NOT_FOUND);
    }
}
