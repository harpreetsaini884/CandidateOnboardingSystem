package com.example.onboarding.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidatePersonalInfoDTO {
    private LocalDate dob;
    private String gender;
    private String address;
    private String nationality;
}
