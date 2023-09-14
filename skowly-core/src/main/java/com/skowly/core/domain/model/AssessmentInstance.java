package com.skowly.core.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class AssessmentInstance extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private double score; // The score of the assessment

	@Lob
	private String feedback; // Optional textual feedback

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEvaluated; // The date the assessment was evaluated

	private AssessmentInstanceStatus status; // The current status (e.g., 'Submitted', 'Graded', 'Incomplete')

	private String submissionUrl; // URL for the submitted work

	@Temporal(TemporalType.TIMESTAMP)
	private Date submissionDate; // The date the work was submitted

	private boolean isSubmitted; // Whether the work has been submitted or not

	private String submissionNotes; // Notes or comments on the submission

	@ManyToOne
	@JoinColumn(name = "assessment_id")
	private Assessment assessment; // The related Assessment entity

	@ManyToOne
	@JoinColumn(name = "enrollment_id")
	private Enrollment enrollment; // The related Enrollment entity

	@OneToMany(mappedBy = "assessmentInstance", cascade = CascadeType.ALL)
	private List<Resource> resources = new ArrayList<>();

}

enum AssessmentInstanceStatus {
	SUBMITTED, GRADED, INCOMPLETE
}
