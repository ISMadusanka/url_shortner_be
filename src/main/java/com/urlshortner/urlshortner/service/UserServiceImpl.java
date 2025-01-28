package com.urlshortner.urlshortner.service;

import com.urlshortner.urlshortner.dao.UserRepository;
import com.urlshortner.urlshortner.dao.VerificationRepository;
import com.urlshortner.urlshortner.entity.User;
import com.urlshortner.urlshortner.entity.Verification;
import com.urlshortner.urlshortner.rest.request.RegistrationRequest;
import com.urlshortner.urlshortner.service.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private VerificationRepository verificationRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, VerificationRepository verificationRepository){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
        this.verificationRepository=verificationRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(RegistrationRequest request) {
        Optional<User> user = this.findByEmail(request.email());
        if (user.isPresent()){
            //TODO throw user already exist exception
        }

        var newUser = new User();
        newUser.setUsername(request.username());
        newUser.setEmail(request.password());
        newUser.setPassword(passwordEncoder.encode(request.password()));
        newUser.setRole(request.role());

        return userRepository.save(newUser);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveVerificationToken(User user, String verificationToken) {
        var verification = new Verification(verificationToken,user);
        verificationRepository.save(verification);


    }


}
