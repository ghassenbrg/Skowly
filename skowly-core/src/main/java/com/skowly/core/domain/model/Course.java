package com.skowly.core.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Course extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name; // Name of the course

	private String subjectCode; // Subject code, e.g., "MATH101"

	private String description; // Description of the course

	private String courseType; // Required, Elective, Lab, etc.

	private int creditHours; // Number of credit hours

	private String syllabus; // Outline or syllabus of the course

	@ManyToOne
	@JoinColumn(name = "academic_class_id")
	private AcademicClass academicClass; // The academic class this course is associated with

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<CourseInstance> courseInstances = new ArrayList<>(); // Instances of this course

	@ManyToMany
	@JoinTable(name = "course_prerequisites", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "prerequisite_id"))
	private List<Course> prerequisites = new ArrayList<>(); // Prerequisite courses

	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
	private List<Resource> resources = new ArrayList<>();

}
