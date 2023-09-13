package com.skowly.core.domain.model;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data public class Address extends SchoolAwareEntity {
	
	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	private String country;

}
