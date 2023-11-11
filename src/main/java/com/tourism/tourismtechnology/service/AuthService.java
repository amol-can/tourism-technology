package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.model.LoginRequest;
import com.tourism.tourismtechnology.model.RegisterRequest;
import com.tourism.tourismtechnology.model.User;
import com.tourism.tourismtechnology.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User login(LoginRequest loginRequest) {
        User user = userRepository.findByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return user;
        }
        throw new IllegalArgumentException("Credentials incorrect!");
    }

    public boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    public User register(RegisterRequest registerRequest) {

        if (userExists(registerRequest.getUsername())) {
            throw new IllegalArgumentException("Username is taken!");
        }

        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(registerRequest.getPassword());
        newUser.setRole(registerRequest.getRole()); // Set default role to CUSTOMER, modify as needed

        return userRepository.save(newUser);
    }
}
