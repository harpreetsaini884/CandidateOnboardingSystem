package com.example.onboarding.repository;

import com.example.onboarding.entity.CandidateDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateDocumentRepository extends JpaRepository<CandidateDocument, Long> {
}
