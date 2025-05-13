package com.example.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationInfoDTO {
    private String degree;
    private String institution;  // Could be renamed to 'university'
    private int yearOfPassing;  // Could be renamed to 'graduationYear'
}
