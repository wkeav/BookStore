package com.bookStore.E_commerce.bookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookStore.E_commerce.bookStore.dto.AuthRequest;
import com.bookStore.E_commerce.bookStore.dto.AuthResponse;
import com.bookStore.E_commerce.bookStore.entities.User;
import com.bookStore.E_commerce.bookStore.security.jwt.JwtUtil;
import com.bookStore.E_commerce.bookStore.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3001") //for react frontend 
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil; 

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder; 

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        try {
            // Find user by email
            User user = userService.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));
            
            // Check password
            if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                return ResponseEntity.badRequest().body("Invalid password");
            }
            
            // Generate token
            String token = jwtUtil.generateToken(user);
            
            // Return token
            return ResponseEntity.ok(new AuthResponse(token));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Login failed");
        }
    }
    
}
