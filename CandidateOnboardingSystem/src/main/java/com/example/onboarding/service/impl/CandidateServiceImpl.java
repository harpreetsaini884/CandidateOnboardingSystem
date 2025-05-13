package com.example.onboarding.service.impl;

import com.example.onboarding.dto.*;
import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.Status;
import com.example.onboarding.repository.CandidateRepository;
import com.example.onboarding.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Override
    public CandidateDTO createCandidate(CandidateDTO candidateDTO) {
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateDTO.getFirstName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setPhoneNumber(candidateDTO.getPhoneNumber());
        // Set other fields if available
        return convertToDTO(candidateRepository.save(candidate));
    }

    @Override
    public CandidateDTO updateCandidate(CandidateDTO candidateDTO, Long id) {
        Candidate candidate = getCandidateOrThrow(id);
        candidate.setFirstName(candidateDTO.getFirstName());
        candidate.setEmail(candidateDTO.getEmail());
        candidate.setPhoneNumber(candidateDTO.getPhoneNumber());
        return convertToDTO(candidateRepository.save(candidate));
    }

    @Override
    public CandidateDTO getCandidate(Long id) {
        return convertToDTO(getCandidateOrThrow(id));
    }

    @Override
    public List<CandidateDTO> getAllCandidates() {
        return candidateRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void updateBankInfo(Long id, BankInfoDTO bankInfoDTO) {
        Candidate candidate = getCandidateOrThrow(id);
        candidate.setBankName(bankInfoDTO.getBankName());
        candidate.setAccountNumber(bankInfoDTO.getAccountNumber());
        candidate.setIfscCode(bankInfoDTO.getIfscCode());
        candidateRepository.save(candidate);
    }

    @Override
    public void updateEducationalInfo(Long id, EducationInfoDTO educationInfoDTO) {
        Candidate candidate = getCandidateOrThrow(id);
        candidate.setDegree(educationInfoDTO.getDegree());
        candidate.setInstitution(educationInfoDTO.getInstitution());
        candidate.setGraduationYear(educationInfoDTO.getYearOfPassing());
        candidateRepository.save(candidate);
    }

    @Override
    public void updatePersonalInfo(Long id, PersonalInfoDTO personalInfoDTO) {
        Candidate candidate = getCandidateOrThrow(id);
        candidate.setFirstName(personalInfoDTO.getName());
        candidate.setEmail(personalInfoDTO.getEmail());
        candidate.setPhoneNumber(personalInfoDTO.getPhone());
        candidateRepository.save(candidate);
    }

    @Override
    public Long getCandidateCount() {
        return candidateRepository.count();
    }

    public Candidate getCandidateOrThrow(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public CandidateDTO convertToDTO(Candidate candidate) {
        CandidateDTO dto = new CandidateDTO();
        dto.setId(candidate.getId());
        dto.setFirstName(candidate.getFirstName());
        dto.setEmail(candidate.getEmail());
        dto.setPhoneNumber(candidate.getPhoneNumber());
        dto.setStatus(candidate.getStatus());
        return dto;
    }

    @Override
    public Candidate getCandidateById(Long id) {
        return getCandidateOrThrow(id);  // Implemented correctly
    }

    @Override
    public CandidateDTO updateStatus(Long id, Status status) {
        Candidate candidate = getCandidateOrThrow(id);
        candidate.setStatus(status);
        return convertToDTO(candidateRepository.save(candidate));
    }

	
}
