package com.skowly.core.model.school;

import jakarta.persistence.Embeddable;

@Embeddable
public class Principal {
	private String principalName; // Principal's name
	private String principalEmail; // Principal's contact email

	public Principal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPrincipalName() {
		return principalName;
	}

	public void setPrincipalName(String principalName) {
		this.principalName = principalName;
	}

	public String getPrincipalEmail() {
		return principalEmail;
	}

	public void setPrincipalEmail(String principalEmail) {
		this.principalEmail = principalEmail;
	}


	
}
