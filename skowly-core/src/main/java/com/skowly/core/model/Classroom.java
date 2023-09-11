package com.skowly.core.model;

import lombok.Data;
import java.util.List;
import com.skowly.core.model.school.School;
import jakarta.persistence.*;

@Entity
@Data
public class Classroom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String className;

	@ManyToOne
	private School school;

	@OneToMany(mappedBy = "classroom")
	private List<Student> students;

	@ManyToMany
	@JoinTable(name = "classroom_courses", joinColumns = @JoinColumn(name = "classroom_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@OneToMany(mappedBy = "classroom")
	private List<TeacherAssignment> teacherAssignments;
	
	
}
