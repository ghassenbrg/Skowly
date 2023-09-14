package com.skowly.core.domain.model;

import java.util.Date;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Enrollment extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date enrollmentDate; // The date of enrollment

	@Enumerated(EnumType.STRING)
	private EnrollmentStatus status; // The status of the enrollment

	private Double finalGrade; // Final grade for the course if applicable

	private Double attendancePercentage; // Attendance percentage if tracked

	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student; // The related Student entity

	@ManyToOne
	@JoinColumn(name = "classGroup_id")
	private ClassGroup classGroup; // The related ClassGroup entity

	@ManyToOne
	@JoinColumn(name = "courseInstance_id")
	private CourseInstance courseInstance; // The related CourseInstance entity
}

// Enum type for EnrollmentStatus
enum EnrollmentStatus {
	ACTIVE, COMPLETED, DROPPED
}
