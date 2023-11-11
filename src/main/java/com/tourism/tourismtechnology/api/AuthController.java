package com.tourism.tourismtechnology.api;

import com.tourism.tourismtechnology.model.LoginRequest;
import com.tourism.tourismtechnology.model.RegisterRequest;
import com.tourism.tourismtechnology.entity.User;
import com.tourism.tourismtechnology.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public User login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    public User register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }
}
