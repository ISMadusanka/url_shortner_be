package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.VerificationRepository;
import com.urlshortner.urlshortner.entity.Verification;
import com.urlshortner.urlshortner.service.services.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    private VerificationRepository verificationRepository;

    @Autowired
    public VerificationServiceImpl(VerificationRepository verificationRepository){
        this.verificationRepository=verificationRepository;
    }

    @Override
    public Verification save(Verification verification) {
        return verificationRepository.save(verification);
    }
}
