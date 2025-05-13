package com.example.onboarding.controller;

import com.example.onboarding.service.impl.DocumentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/candidates/{candidateId}/documents")
@RequiredArgsConstructor
public class CandidateDocumentController {

    private final DocumentServiceImpl documentService;

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadDocument(
            @PathVariable Long candidateId,
            @RequestParam("documentType") String documentType,
            @RequestParam("file") MultipartFile file) {

        documentService.uploadDocument(candidateId, documentType, file);
        return ResponseEntity.noContent().build();
    }
}
