package com.example.onboarding.controller;

import com.example.onboarding.dto.PersonalInfoDTO;
import com.example.onboarding.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidates/{id}/personal-info")
@RequiredArgsConstructor
public class CandidatePersonalInfoController {

    private final CandidateService candidateService;

    @PutMapping
    public ResponseEntity<Void> updatePersonalInfo(@PathVariable Long id, @RequestBody PersonalInfoDTO personalInfoDTO) {
        candidateService.updatePersonalInfo(id, personalInfoDTO);
        return ResponseEntity.noContent().build();
    }
}
