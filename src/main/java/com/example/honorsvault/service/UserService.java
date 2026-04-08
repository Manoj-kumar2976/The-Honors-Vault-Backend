package com.example.honorsvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.honorsvault.model.User;
import com.example.honorsvault.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User signup(User user) {
        return repo.save(user);
    }

    public User login(String email, String password) {
        return repo.findByEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .orElse(null);
    }
}