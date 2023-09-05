package com.skowly.core.model.school;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import com.skowly.core.model.security.User;

@Entity
@Table(name = "schools")
public class School {
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

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

    @ManyToMany(mappedBy = "schools")
    private Set<User> users; // Users who belong to the school

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Principal getPrincipal() {
		return principal;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}

	public int getTotalStudents() {
		return totalStudents;
	}

	public void setTotalStudents(int totalStudents) {
		this.totalStudents = totalStudents;
	}

	public int getTotalTeachers() {
		return totalTeachers;
	}

	public void setTotalTeachers(int totalTeachers) {
		this.totalTeachers = totalTeachers;
	}

	public String getMapsPosition() {
		return mapsPosition;
	}

	public void setMapsPosition(String mapsPosition) {
		this.mapsPosition = mapsPosition;
	}

	public Date getFoundingDate() {
		return foundingDate;
	}

	public void setFoundingDate(Date foundingDate) {
		this.foundingDate = foundingDate;
	}

	public String getAccreditation() {
		return accreditation;
	}

	public void setAccreditation(String accreditation) {
		this.accreditation = accreditation;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public String getExtracurricularActivities() {
		return extracurricularActivities;
	}

	public void setExtracurricularActivities(String extracurricularActivities) {
		this.extracurricularActivities = extracurricularActivities;
	}

	public String getAdmissionProcess() {
		return admissionProcess;
	}

	public void setAdmissionProcess(String admissionProcess) {
		this.admissionProcess = admissionProcess;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		School other = (School) obj;
		return Objects.equals(id, other.id);
	}


}
