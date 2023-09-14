package com.skowly.core.domain.model;

import java.time.LocalDate;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class User extends SchoolAwareEntity {

	private String firstName;

	private String lastName;

	private String email;

	private String phoneNumber;

	private LocalDate dateOfBirth;

	private String profilPhotoUrl;

	@Embedded
	private Address address;

}