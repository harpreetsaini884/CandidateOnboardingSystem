package com.example.onboarding.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onboarding.entity.LoginCandidate;

@Repository
public interface LoginCandidateRepository extends JpaRepository<LoginCandidate,Long>{
	Optional<LoginCandidate> findByUsername(String username);
    Optional<LoginCandidate> findByEmail(String email);

}
