package com.skowly.core.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToOne
    private Classroom classroom;

    
	@OneToMany(mappedBy = "course")
	private List<CourseAssignment> courseAssignments;
}