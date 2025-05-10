package com.example.onboarding.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // generates getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String status;
    private String position;
}
