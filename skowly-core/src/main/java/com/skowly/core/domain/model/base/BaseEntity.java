package com.skowly.core.domain.model.base;

import java.time.ZonedDateTime;

import com.skowly.core.security.SecurityUtils;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Version;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@MappedSuperclass
public abstract class BaseEntity {

	@Version
	@Setter(AccessLevel.PRIVATE)
	private Long version;

	@Column(updatable = false)
	@Setter(AccessLevel.PRIVATE)
	private String creatorUserId;

	@Column(updatable = false)
	@Setter(AccessLevel.PRIVATE)
	private ZonedDateTime createdAt;

	@Setter(AccessLevel.PRIVATE)
	private ZonedDateTime updatedAt;

	@Setter(AccessLevel.PRIVATE)
	private String updaterUserId;

	@PrePersist
	protected void onCreate() {
		this.createdAt = ZonedDateTime.now();
		this.creatorUserId = SecurityUtils.getCurrentUser();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = ZonedDateTime.now();
		this.updaterUserId = SecurityUtils.getCurrentUser();
	}

}
