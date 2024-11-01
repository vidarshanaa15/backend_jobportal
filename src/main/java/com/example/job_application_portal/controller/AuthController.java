package com.example.job_application_portal.controller;

import com.example.job_application_portal.entity.User;
import com.example.job_application_portal.service.AuthService; // Adjust the path as necessary
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User loginRequest) {
        // Assuming User model contains username and password fields
        boolean isAuthenticated = authService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            // You can return user details or a success message here
            return ResponseEntity.ok("Login successful!"); // Customize as needed
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
