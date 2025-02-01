package com.planify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.planify.exception.DuplicateUserException;
import com.planify.model.User;
import com.planify.repository.UserRepository;

@Service
public class UserService {

    @Autowired

    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User registerUser(User user) {

        logger.info("Registering user: {}", user);

        if (!user.getCategory().matches("Student|Coordinator|Faculty")) {
            throw new IllegalArgumentException("Invalid category");
        }
        
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateUserException("Email already exists");
        }
        
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            if (updatedUser.getFirstname() != null) user.setFirstname(updatedUser.getFirstname());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getPassword() != null) user.setPassword(updatedUser.getPassword());
            if (updatedUser.getCategory() != null) user.setCategory(updatedUser.getCategory());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}