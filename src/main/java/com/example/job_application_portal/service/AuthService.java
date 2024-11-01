package com.example.job_application_portal.service;

import com.example.job_application_portal.entity.User;
import com.example.job_application_portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username); // Find user by username
        return user != null && user.getPassword().equals(password);
    }
}
