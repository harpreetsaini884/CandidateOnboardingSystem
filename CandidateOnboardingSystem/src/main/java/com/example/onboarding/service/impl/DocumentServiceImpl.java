package com.example.onboarding.service.impl;

import com.example.onboarding.entity.Candidate;
import com.example.onboarding.entity.CandidateDocument;
import com.example.onboarding.repository.CandidateDocumentRepository;
import com.example.onboarding.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl {

    private final CandidateDocumentRepository candidateDocumentRepository;
    private final CandidateRepository candidateRepository;

    public void uploadDocument(Long candidateId, String documentType, MultipartFile file) {
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        try {
            CandidateDocument document = new CandidateDocument();
            document.setCandidate(candidate);
            document.setDocumentType(documentType);
            document.setData(file.getBytes());
            document.setFileUrl(file.getOriginalFilename());

            candidateDocumentRepository.save(document);
        } catch (IOException e) {
            throw new RuntimeException("Failed to upload document", e);
        }
    }
}
