package com.example.onboarding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onboarding.entity.CandidatePersonalInfo;

public interface CandidatePersonalInfoRepository extends JpaRepository<CandidatePersonalInfo, Long> {
    Optional<CandidatePersonalInfo> findByCandidateId(Long candidateId);
}

