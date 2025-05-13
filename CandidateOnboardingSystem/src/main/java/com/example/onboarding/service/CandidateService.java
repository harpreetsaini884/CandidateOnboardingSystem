package com.example.onboarding.service;

import java.util.List;

import com.example.onboarding.dto.BankInfoDTO;
import com.example.onboarding.dto.CandidateDTO;
import com.example.onboarding.dto.EducationInfoDTO;
import com.example.onboarding.dto.PersonalInfoDTO;
import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.Status;  // Correct import for Status

public interface CandidateService {
    CandidateDTO createCandidate(CandidateDTO candidateDTO);
    CandidateDTO updateCandidate(CandidateDTO candidateDTO, Long id);
    Candidate getCandidateById(Long id);
    CandidateDTO getCandidate(Long id);
    List<CandidateDTO> getAllCandidates();
    CandidateDTO updateStatus(Long id, Status status);  // Corrected method signature
    Long getCandidateCount();

    void updateBankInfo(Long id, BankInfoDTO bankInfoDTO);
    void updateEducationalInfo(Long id, EducationInfoDTO educationInfoDTO);
    void updatePersonalInfo(Long id, PersonalInfoDTO personalInfoDTO);
}
