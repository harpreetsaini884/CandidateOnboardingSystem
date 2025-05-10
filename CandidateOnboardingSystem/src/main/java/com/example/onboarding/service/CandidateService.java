// --- Service ---
package com.example.onboarding.service;

import com.example.onboarding.dto.CandidateDTO;
import com.example.onboarding.entity.Candidate;
import com.example.onboarding.exception.CandidateNotFoundException;
import com.example.onboarding.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateService {
	
	
	private final CandidateRepository repository;

    

    public List<CandidateDTO> getAllCandidates() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public CandidateDTO getCandidate(Long id) {
        Candidate candidate = repository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with ID " + id + " not found"));
        return toDTO(candidate);
    }

    public CandidateDTO updateStatus(Long id, String status) {
        Candidate target_candidate = repository.findById(id)
                .orElseThrow(() -> new CandidateNotFoundException("Candidate with ID " + id + " not found"));
        target_candidate.setStatus(status) ; 
        return toDTO(repository.save(target_candidate));
    }
    
    private CandidateDTO toDTO(Candidate candidate) {
        return CandidateDTO.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .email(candidate.getEmail())
                .status(candidate.getStatus())
                .position(candidate.getPosition())
                .build();
    }
    public CandidateDTO createCandidate(CandidateDTO dto) {
        Candidate candidate = Candidate.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .status(dto.getStatus())
                .position(dto.getPosition())
                .build();

        Candidate saved = repository.save(candidate);
        return toDTO(saved);
    }


}