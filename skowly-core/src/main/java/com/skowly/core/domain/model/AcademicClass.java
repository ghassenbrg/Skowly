package com.skowly.core.domain.model;

import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AcademicClass extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name; // e.g., "Science Class for 10th Grade"

	private String academicYear; // e.g., "2022-2023"

	private int capacity; // Maximum number of students

	private String gradeLevel; // e.g., "10th Grade"

	private AcademicClassStatus status; // e.g., "Active", "Completed", "Planned"

	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;

	@OneToMany(mappedBy = "academicClass")
	private List<Course> courses;

	@OneToMany(mappedBy = "academicClass") // Please update the mapping in ClassGroup as well
	private List<ClassGroup> classGroups;
}

enum AcademicClassStatus {
	ACTIVE, COMPLETED, PLANNED
}
