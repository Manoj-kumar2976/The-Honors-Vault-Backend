package com.example.honorsvault.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.honorsvault.model.Achievement;
import com.example.honorsvault.service.AchievementService;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin("*")
public class AchievementController {

    @Autowired
    private AchievementService service;

    @PostMapping
    public Achievement add(@RequestBody Achievement a) {
        return service.save(a);
    }

    @GetMapping
    public List<Achievement> getAll() {
        return service.getAll();
    }

    @GetMapping("/student/{email}")
    public List<Achievement> getByStudent(@PathVariable String email) {
        return service.getByEmail(email);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}