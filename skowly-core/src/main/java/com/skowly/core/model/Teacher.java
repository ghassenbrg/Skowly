package com.skowly.core.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import com.skowly.core.model.school.School;

@Data
@Entity
public class Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@OneToMany(mappedBy = "teacher")
	private List<CourseAssignment> courseAssignments;
}