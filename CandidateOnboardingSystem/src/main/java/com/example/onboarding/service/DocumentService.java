package com.example.onboarding.service;

import com.example.onboarding.dto.DocumentDTO;

import java.util.List;

public interface DocumentService {
    List<DocumentDTO> getDocumentsForCandidate(Long candidateId);
    void uploadDocument(Long candidateId, DocumentDTO dto);
    void verifyDocument(Long documentId);
}
