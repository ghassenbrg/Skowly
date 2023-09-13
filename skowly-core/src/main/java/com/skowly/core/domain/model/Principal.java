package com.skowly.core.domain.model;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data public class Principal extends SchoolAwareEntity {
	
	private String principalName; // Principal's name
	private String principalEmail; // Principal's contact email

}
