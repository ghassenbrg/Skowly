package com.skowly.core.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class Principal {

	@NotBlank
	private String principalName; // Principal's name

	@Email
	@NotBlank
	private String principalEmail; // Principal's contact email

}
