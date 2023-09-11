package com.skowly.core.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Classroom> classrooms;

    @ManyToMany(mappedBy = "courses")
    private List<Teacher> teachers;
}