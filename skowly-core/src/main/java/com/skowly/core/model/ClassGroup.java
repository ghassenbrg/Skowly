package com.skowly.core.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data public class ClassGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String groupName;
	
	@ManyToOne
	private Classroom classroom;

	@OneToMany(mappedBy = "group")
	private List<Student> students;

	@OneToMany(mappedBy = "group")
	private List<CourseAssignment> courseAssignments;
	
}
