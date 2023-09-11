package com.skowly.core.model;

import lombok.Data;
import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Data
@Entity
public class TeacherAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Classroom classroom;

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Course course;
}