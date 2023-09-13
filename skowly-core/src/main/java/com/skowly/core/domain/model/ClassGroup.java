package com.skowly.core.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class ClassGroup extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "timeTable_id")
	private TimeTable timeTable;

	@OneToMany(mappedBy = "classGroup")
	private List<Enrollment> enrollments;

}
