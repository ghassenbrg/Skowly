package com.skowly.core.domain.model;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Embeddable
@EqualsAndHashCode(callSuper = true)
public class Principal extends SchoolAwareEntity {
	
	private String principalName; // Principal's name
	private String principalEmail; // Principal's contact email

}
