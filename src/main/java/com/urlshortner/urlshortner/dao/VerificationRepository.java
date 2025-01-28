package com.urlshortner.urlshortner.dao;

import com.urlshortner.urlshortner.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationRepository extends JpaRepository<Verification,Long> {
    Verification findByToken(String token);
}
