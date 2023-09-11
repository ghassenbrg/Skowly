package com.skowly.core.model;

import lombok.Data;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Data
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String className;
	
	@OneToMany(mappedBy = "classroom")
	private List<ClassGroup> groups;

	@OneToMany(mappedBy = "classroom")
	private List<Course> courses;
	



}
