package com.example.onboarding.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDTO {
    private Long id;
    private String name;
    private String email;
    private String status;
    private String position;
	
}