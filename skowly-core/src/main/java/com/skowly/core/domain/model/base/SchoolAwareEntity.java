package com.skowly.core.domain.model.base;

import com.skowly.core.security.SecurityUtils;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = true)
public abstract class SchoolAwareEntity extends BaseEntity {

	@Column(updatable = false)
	@Setter(AccessLevel.PRIVATE)
	private String schoolId;

	@Override
	@PrePersist
	protected void onCreate() {
		this.schoolId = (String) SecurityUtils.getTokenAttribute("school_id");
	}

}
