package com.skowly.core.domain.model;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Assessment extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name; // Name of the assessment, e.g., "Midterm Exam"

	private String description; // Additional details about the assessment

	private double weight; // Weight of the assessment in the final grade

	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate; // Due date for the assessment

	private AssessmentType assessmentType; // Type of assessment: 'Exam', 'Quiz', 'Project', etc.

	private int totalPoints; // Total points that can be scored in the assessment

	private String instructions; // Detailed instructions for completing the assessment

	@OneToMany(mappedBy = "assessment", cascade = CascadeType.ALL)
	private List<AssessmentInstance> assessmentInstances; // Results of the assessment for each student

	@ManyToOne
	@JoinColumn(name = "courseInstance_id")
	private CourseInstance courseInstance; // The course instance for which the assessment is

}

enum AssessmentType {
	EXAM, QUIZ, PROJECT, HOMEWORK
}
