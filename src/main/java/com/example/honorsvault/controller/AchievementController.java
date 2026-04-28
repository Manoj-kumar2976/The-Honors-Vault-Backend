package com.example.honorsvault.controller;

import com.example.honorsvault.model.Achievement;
import com.example.honorsvault.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/achievements")
@CrossOrigin(origins = "https://the-honors-vault-klu.vercel.app")
public class AchievementController {

    @Autowired
    private AchievementService service;

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Achievement a) {
        try {
            return ResponseEntity.status(201).body(service.save(a));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<List<Achievement>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/student/{email}")
    public ResponseEntity<List<Achievement>> getByStudent(@PathVariable String email) {
        return ResponseEntity.ok(service.getByEmail(email));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Achievement updated) {
        try {
            return ResponseEntity.ok(service.update(id, updated));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}