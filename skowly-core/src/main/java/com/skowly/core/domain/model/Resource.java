package com.skowly.core.domain.model;

import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Resource extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Lob
	private String notes;

	@OneToMany(mappedBy = "resource")
	private List<Document> documents;

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@ManyToOne
	@JoinColumn(name = "courseInstance_id")
	private CourseInstance courseInstance;

	@ManyToOne
	@JoinColumn(name = "assessmentInstance_id")
	private AssessmentInstance assessmentInstance;

}
