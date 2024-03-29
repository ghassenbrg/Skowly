package com.skowly.core.domain.model;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Document extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fileName;
	private String fileUrl;
	private String fileExtension;

	@ManyToOne
	@JoinColumn(name = "resource_id")
	private Resource resource;
}
