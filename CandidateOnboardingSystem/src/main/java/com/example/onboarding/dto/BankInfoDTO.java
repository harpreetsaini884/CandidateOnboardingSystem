package com.example.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankInfoDTO {
    private String bankName;
    private String accountNumber;
    private String ifscCode;
}
