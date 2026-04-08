package com.example.honorsvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.honorsvault.model.User;
import com.example.honorsvault.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return service.signup(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User user) {
        return service.login(user.getEmail(), user.getPassword());
    }
}