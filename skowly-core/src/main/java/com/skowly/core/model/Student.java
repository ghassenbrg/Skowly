package com.skowly.core.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;

	@ManyToOne
	private ClassGroup classGroup;

}