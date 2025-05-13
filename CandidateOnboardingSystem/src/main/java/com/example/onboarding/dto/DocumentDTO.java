package com.example.onboarding.dto;



import lombok.Data;

@Data
public class DocumentDTO {
    private String documentType;
    private String fileUrl;
    private Boolean verified;
}
