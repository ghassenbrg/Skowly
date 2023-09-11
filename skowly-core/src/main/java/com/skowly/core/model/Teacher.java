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

	@ManyToOne
	private School school;

	@ManyToMany
	@JoinTable(name = "teacher_courses", joinColumns = @JoinColumn(name = "teacher_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
	private List<Course> courses;

	@OneToMany(mappedBy = "teacher")
	private List<TeacherAssignment> teacherAssignments;
}