package com.example.honorsvault.model;

import jakarta.persistence.*;

@Entity
@Table(name = "achievements")
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

    public Long getId() { return id; }
    public String getStudentName() { return studentName; }
    public String getStudentEmail() { return studentEmail; }
    public String getActivity() { return activity; }
    public String getCategory() { return category; }
    public String getLevel() { return level; }
    public String getDate() { return date; }
    public String getDescription() { return description; }

    public void setId(Long id) { this.id = id; }
    public void setStudentName(String n) { this.studentName = n; }
    public void setStudentEmail(String e) { this.studentEmail = e != null ? e.trim().toLowerCase() : null; }
    public void setActivity(String a) { this.activity = a; }
    public void setCategory(String c) { this.category = c; }
    public void setLevel(String l) { this.level = l; }
    public void setDate(String d) { this.date = d; }
    public void setDescription(String d) { this.description = d; }
}