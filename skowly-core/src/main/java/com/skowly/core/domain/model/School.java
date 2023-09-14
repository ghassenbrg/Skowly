package com.skowly.core.domain.model;

import java.util.Date;
import java.util.List;

import com.skowly.core.domain.model.base.BaseEntity;

import jakarta.persistence.ElementCollection;
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
	private String name;
	private String description;

	@Embedded
	private Address address;
	private String phoneNumber;
	private String website;
	private String email;
	private String logoUrl; // URL to the school's logo

	@Embedded
	private Principal principal;

	private int totalStudents;
	private int totalTeachers;
	private String mapsPosition;

	@Temporal(TemporalType.DATE)
	private Date foundingDate;
	private String accreditation;
	private String facilities;
	private String extracurricularActivities;
	private String admissionProcess;

	@ElementCollection
	private List<String> socialMediaHandles; // List of social media handles or URLs

	@OneToMany(mappedBy = "school")
	private List<AcademicClass> academicClasses;

	@OneToMany(mappedBy = "school")
	private List<Teacher> teachers; // All teachers associated with this school

	@OneToMany(mappedBy = "school")
	private List<Student> students; // All students associated with this school

	@OneToMany(mappedBy = "school")
	private List<Classroom> classrooms;

}
