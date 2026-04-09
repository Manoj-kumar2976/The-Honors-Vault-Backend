package com.example.honorsvault.service;

import com.example.honorsvault.model.Achievement;
import com.example.honorsvault.repository.AchievementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        return repo.findByStudentEmail(email.trim().toLowerCase());
    }

    public Achievement update(Long id, Achievement updated) {
        Achievement existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Achievement not found: " + id));
        if (updated.getActivity() != null) existing.setActivity(updated.getActivity());
        if (updated.getCategory() != null) existing.setCategory(updated.getCategory());
        if (updated.getLevel() != null) existing.setLevel(updated.getLevel());
        if (updated.getDate() != null) existing.setDate(updated.getDate());
        if (updated.getDescription() != null) existing.setDescription(updated.getDescription());
        if (updated.getStudentName() != null) existing.setStudentName(updated.getStudentName());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}