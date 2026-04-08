package com.example.honorsvault.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.honorsvault.model.Achievement;
import java.util.List;

public interface AchievementRepository extends JpaRepository<Achievement, Long> {
    List<Achievement> findByStudentEmail(String studentEmail);
}