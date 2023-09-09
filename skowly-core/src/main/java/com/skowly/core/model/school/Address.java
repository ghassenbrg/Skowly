package com.skowly.core.model.school;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data public class Address {



	private String streetAddress;
	private String city;
	private String state;
	private String postalCode;
	private String country;

}
