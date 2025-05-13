package com.example.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private OnboardStatus onboardStatus;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Add these fields for educational info
    private String degree;
    private String institution; // Instead of 'university'
    private Integer graduationYear; // Instead of 'yearOfPassing'
    
    // Add these fields for bank info
    private String bankName;
    private String accountNumber;
    private String ifscCode;
}
