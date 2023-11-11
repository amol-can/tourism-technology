package com.tourism.tourismtechnology.service;

import com.tourism.tourismtechnology.model.LoginRequest;
import com.tourism.tourismtechnology.model.RegisterRequest;
import com.tourism.tourismtechnology.entity.User;
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
        if (user == null) {
            throw new IllegalArgumentException("Credentials incorrect!");
        }
        return user;
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
        newUser.setRole(User.ROLE.valueOf(registerRequest.getRole()));

        return userRepository.save(newUser);
    }
}
