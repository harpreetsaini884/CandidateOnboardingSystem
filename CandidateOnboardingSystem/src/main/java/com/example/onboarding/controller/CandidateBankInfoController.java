package com.example.onboarding.controller;

import com.example.onboarding.dto.BankInfoDTO;
import com.example.onboarding.service.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates/{id}/bank-info")
public class CandidateBankInfoController {

    @Autowired
    private CandidateServiceImpl candidateService;

    // Update candidate's bank information
    @PutMapping
    public ResponseEntity<Void> updateBankInfo(@PathVariable Long id, @RequestBody BankInfoDTO bankInfoDTO) {
        candidateService.updateBankInfo(id, bankInfoDTO);
        return ResponseEntity.noContent().build();
    }
}
