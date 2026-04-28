package com.example.honorsvault.service;

import com.example.honorsvault.model.User;
import com.example.honorsvault.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User signup(User user) {

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Email is required");
        }

        if (user.getPassword() == null || user.getPassword().length() < 6) {
            throw new RuntimeException("Password must be at least 6 characters");
        }

        String email = user.getEmail().trim().toLowerCase();

        if (repo.existsByEmail(email)) {
            throw new RuntimeException("Email already registered");
        }

        user.setEmail(email);
        user.setRole(user.getRole() != null
                ? user.getRole().trim().toLowerCase()
                : "student");

        return repo.save(user);
    }

    public User login(String email, String password) {

        if (email == null || password == null) {
            throw new RuntimeException("Email and password required");
        }

        String e = email.trim().toLowerCase();

        return repo.findByEmail(e)
                .filter(u -> u.getPassword() != null && u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public List<User> getUsersByRole(String role) {
        return repo.findByRole(role);
    }
}