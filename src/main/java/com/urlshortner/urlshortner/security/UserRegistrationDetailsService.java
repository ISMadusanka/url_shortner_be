package com.urlshortner.urlshortner.security;

import com.urlshortner.urlshortner.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserRegistrationDetailsService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email).map(UserRegistrationDetails::new).orElseThrow(()-> new UsernameNotFoundException("User not found"));
    }
}
