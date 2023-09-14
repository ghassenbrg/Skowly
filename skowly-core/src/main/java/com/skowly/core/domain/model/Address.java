package com.skowly.core.domain.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Embeddable
public class Address {

	@NotBlank
	@Size(max = 100)
	private String streetAddress;

	@NotBlank
	@Size(max = 50)
	private String city;

	@Size(max = 50)
	private String state;

	@NotBlank
	@Size(max = 20)
	private String postalCode;

	@NotBlank
	@Size(max = 50)
	private String country;
}
