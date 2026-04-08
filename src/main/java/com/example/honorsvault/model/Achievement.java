package com.example.honorsvault.model;

import jakarta.persistence.*;

@Entity
public class Achievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentName;
    private String studentEmail;
    private String activity;
    private String category;
    private String level;
    private String date;

    @Column(length = 1000)
    private String description;

    // ✅ GETTERS
    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getStudentEmail() { return studentEmail; }
    public String getActivity() { return activity; }
    public String getCategory() { return category; }
    public String getLevel() { return level; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    // ✅ SETTERS
    public void setId(Long id) { this.id = id; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
    public void setStudentEmail(String studentEmail) { this.studentEmail = studentEmail; }
    public void setActivity(String activity) { this.activity = activity; }
    public void setCategory(String category) { this.category = category; }
    public void setLevel(String level) { this.level = level; }
    public void setDate(String date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }
}