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
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassGroup extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name; // Name of the class group

	private boolean isActive; // Whether the class group is currently active

	private String academicYear; // Academic year this class group belongs to

	private String subjectFocus; // Specific subject focus, if any

	private String scheduleType; // Daily, Weekly, Bi-weekly, etc.

	@ManyToOne
	@JoinColumn(name = "academicClass_id") // Renamed to match AcademicClass
	private AcademicClass academicClass; // The academic class this class group belongs to

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "timeTable_id")
	private TimeTable timeTable; // TimeTable for this class group

	@OneToMany(mappedBy = "classGroup", cascade = CascadeType.ALL)
	private List<Enrollment> enrollments = new ArrayList<>(); // Students enrolled in this class group
}
