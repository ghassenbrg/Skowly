package com.skowly.core.model.school;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data public class Principal {
	
	private String principalName; // Principal's name
	private String principalEmail; // Principal's contact email

}
