package com.eoms.auth_service.controller;

import com.eoms.auth_service.dto.AuthResponse;
import com.eoms.auth_service.dto.LoginRequest;
import com.eoms.auth_service.dto.RegisterRequest;
import com.eoms.auth_service.model.Role;
import com.eoms.auth_service.model.User;
import com.eoms.auth_service.repository.UserRepository;
import com.eoms.auth_service.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest req) {

        User user = new User();
        user.setUsername(req.username());
        user.setEmail(req.email());
        user.setPassword(encoder.encode(req.password()));
        user.setRole(Role.USER);

        userRepo.save(user);

        return "User registered successfully";
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest req) {

        User user = userRepo.findByUsername(req.username())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(req.password(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return new AuthResponse(token);
    }
}

