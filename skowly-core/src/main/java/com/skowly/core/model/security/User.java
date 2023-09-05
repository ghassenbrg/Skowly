package com.skowly.core.model.security;

import jakarta.persistence.*;
import java.util.Set;

import com.skowly.core.model.school.School;

@Entity
@Table(name = "users")
public class User {
	
	public User() {
		super();
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String securityUserId;



	@ManyToMany
    @JoinTable(
        name = "user_school",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "school_id")
    )
    private Set<School> schools; // Schools the user belongs to

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSecurityUserId() {
		return securityUserId;
	}

	public void setSecurityUserId(String securityUserId) {
		this.securityUserId = securityUserId;
	}

	public Set<School> getSchools() {
		return schools;
	}

	public void setSchools(Set<School> schools) {
		this.schools = schools;
	}


}
