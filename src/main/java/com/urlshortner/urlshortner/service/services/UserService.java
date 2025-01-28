package com.urlshortner.urlshortner.service.services;

import com.urlshortner.urlshortner.entity.User;
import com.urlshortner.urlshortner.rest.request.RegistrationRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User registerUser(RegistrationRequest request);
    Optional<User> findByEmail(String email);
    void saveVerificationToken(User user, String verificationToken);
}
