package com.example.onboarding.controller;

import com.example.onboarding.dto.EducationInfoDTO;
import com.example.onboarding.service.impl.CandidateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates/{id}/educational-info")
public class CandidateEducationController {

    @Autowired
    private CandidateServiceImpl candidateService;

    // Update candidate's educational information
    @PutMapping
    public ResponseEntity<Void> updateEducationalInfo(@PathVariable Long id, @RequestBody EducationInfoDTO educationInfoDTO) {
        candidateService.updateEducationalInfo(id, educationInfoDTO);
        return ResponseEntity.noContent().build();
    }
}
