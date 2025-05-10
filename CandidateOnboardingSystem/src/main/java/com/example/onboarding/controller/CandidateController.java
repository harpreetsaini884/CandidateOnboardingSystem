package com.example.onboarding.controller;

import com.example.onboarding.dto.CandidateDTO;
import com.example.onboarding.dto.StatusUpdateRequest;
import com.example.onboarding.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService service;

    @GetMapping("/hired")
    public ResponseEntity<List<CandidateDTO>> getAll() {
        return ResponseEntity.ok(service.getAllCandidates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCandidate(id));
    }

    @PostMapping("/{id}/status")
    public ResponseEntity<CandidateDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody StatusUpdateRequest request
    ) {
        return ResponseEntity.ok(service.updateStatus(id, request.getStatus()));
    }

    
    @PostMapping
    public ResponseEntity<CandidateDTO> createCandidate(@RequestBody CandidateDTO candidateDTO) {
        return ResponseEntity.ok(service.createCandidate(candidateDTO));
    }

}
