package com.skowly.core.model.school;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

import com.skowly.core.model.Classroom;
import com.skowly.core.model.Teacher;

@Entity
@Table(name = "schools")
@Data
public class School {

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


}
