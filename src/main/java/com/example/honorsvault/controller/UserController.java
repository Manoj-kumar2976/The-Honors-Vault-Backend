package com.example.honorsvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.honorsvault.model.User;
import com.example.honorsvault.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // ✅ GET ALL USERS
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}