package com.example.onboarding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobOfferNotification {
	private Long candidateId;
	private String email;
}
