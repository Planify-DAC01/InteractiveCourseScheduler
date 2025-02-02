package com.planify.service;

import com.planify.auth.*;
import com.planify.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.planify.repository.UserRepository;

@Service
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
    // Constructor-based injection
    public AuthenticationService(AuthenticationManager authenticationManager, UserRepository userRepository ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }
    public User authenticate(LoginRequest input) { 
        logger.info("Authenticating user: {}", input.getEmail());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()

                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}
