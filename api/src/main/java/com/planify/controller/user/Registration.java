package com.planify.controller.user;
import org.springframework.web.bind.annotation.RestController;

import com.planify.auth.JwtUtil;
import com.planify.auth.LoginRequest;
import com.planify.auth.LoginResponse;
import com.planify.model.Response;
import com.planify.model.User;
import com.planify.service.AuthenticationService;
import com.planify.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class Registration {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<Response> postMethodName(@RequestBody User request) {
        User registeredUser = userService.registerUser(request);
        Response successResponse = new Response(
            HttpStatus.CREATED.value(),
            "User registered successfully",
            registeredUser );
         return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }
    
}
