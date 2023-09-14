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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class CourseInstance extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course; // The course this instance is based on

	@ManyToOne
	@JoinColumn(name = "teacher_id")
	private Teacher instructor; // The instructor for this course instance

	@OneToMany(mappedBy = "courseInstance", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments = new ArrayList<>(); // List of students enrolled in this course instance

	@OneToMany(mappedBy = "courseInstance", cascade = CascadeType.ALL)
	private List<Assessment> assessments;

	@OneToMany(mappedBy = "courseInstance", cascade = CascadeType.ALL)
	private List<Resource> resources = new ArrayList<>();

	@OneToMany(mappedBy = "courseInstance", cascade = CascadeType.ALL)
	private List<TimeSlot> timeSlots = new ArrayList<>();

	private String semester; // The semester when this course is offered

	private int maxEnrollment; // Maximum number of students that can enroll

	private String syllabus; // A syllabus specifically for this course instance
}
