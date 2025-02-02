package com.planify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.planify.exception.DuplicateUserException;
import com.planify.model.User;
import com.planify.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;
    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User registerUser(User user) {

        if (!user.getCategory().matches("Student|Coordinator|Faculty")) {
            throw new IllegalArgumentException("Invalid category");
        }
        
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateUserException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            if (updatedUser.getFirstname() != null) user.setFirstname(updatedUser.getFirstname());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());
            if (updatedUser.getPassword() != null) user.setPassword(passwordEncoder.encode(user.getPassword()));
            if (updatedUser.getCategory() != null) user.setCategory(updatedUser.getCategory());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }
}