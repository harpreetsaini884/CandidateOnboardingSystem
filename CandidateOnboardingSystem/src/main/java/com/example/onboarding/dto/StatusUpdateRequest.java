package com.example.onboarding.dto;

import com.example.onboarding.entity.Status;

import lombok.Data;

@Data
public class StatusUpdateRequest {
    private Status status;
}
