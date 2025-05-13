package com.example.onboarding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.onboarding")
public class CandidateOnboardingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CandidateOnboardingSystemApplication.class, args);
        System.out.println("I am Ready to Run");
    }
}



