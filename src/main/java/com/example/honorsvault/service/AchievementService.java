package com.example.honorsvault.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.honorsvault.model.Achievement;
import com.example.honorsvault.repository.AchievementRepository;

import java.util.List;

@Service
public class AchievementService {

    @Autowired
    private AchievementRepository repo;

    public Achievement save(Achievement a) {
        return repo.save(a);
    }

    public List<Achievement> getAll() {
        return repo.findAll();
    }

    public List<Achievement> getByEmail(String email) {
        return repo.findByStudentEmail(email);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}