package com.skowly.core.domain.model;

import java.util.Date;
import java.util.List;

import com.skowly.core.domain.model.base.BaseEntity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "schools")
@Data
@EqualsAndHashCode(callSuper = true)
public class School extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name; // School name
	private String description; // Description or information about the school

	@Embedded
	private Address address; // School address
	private String phoneNumber; // School phone number
	private String website; // School website URL
	private String email; // School contact email

	@Embedded
	private Principal principal; // Principal's information

	private int totalStudents; // Total number of students in the school
	private int totalTeachers; // Total number of teachers in the school
	private String mapsPosition; // Coordinates or location on maps

	@Temporal(TemporalType.DATE)
	private Date foundingDate; // Date when the school was founded
	private String accreditation; // Accreditation details, if applicable
	private String facilities; // Information about school facilities
	private String extracurricularActivities; // List of extracurricular activities offered
	private String admissionProcess; // Information on the admission process

	@OneToMany(mappedBy = "school")
	private List<Classroom> classrooms;

	@OneToMany(mappedBy = "school")
	private List<Course> courses;

}
