package com.planify.controller;
import org.springframework.web.bind.annotation.RestController;

import com.planify.model.Response;
import com.planify.model.User;
import com.planify.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api")
public class Registration {
    @Autowired
    private UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(Registration.class);

    @PostMapping("/signup")
    public ResponseEntity<Response> postMethodName(@RequestBody User request) {
        User registeredUser = userService.registerUser(request);
        logger.info("Registered user: {}", registeredUser);
        Response successResponse = new Response(
            HttpStatus.CREATED.value(),
            "User registered successfully",
            registeredUser );
         return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }
    
}
