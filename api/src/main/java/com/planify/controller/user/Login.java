package com.planify.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.planify.auth.JwtUtil;
import com.planify.auth.LoginRequest;
import com.planify.auth.LoginResponse;
import com.planify.model.User;
import com.planify.service.AuthenticationService;

@RestController
public class Login {

    private static final Logger logger = LoggerFactory.getLogger(Registration.class);

    private JwtUtil jwtService;
    private AuthenticationService authenticationService;

    public Login(JwtUtil jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }
    
    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginUser) {
        User authenticatedUser = authenticationService.authenticate(loginUser);
        logger.info("User with email id '{}' authenticated successfully", authenticatedUser.getEmail());
        String jwtToken = jwtService.generateToken(authenticatedUser.getEmail());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        return ResponseEntity.ok(loginResponse);
    }
}
