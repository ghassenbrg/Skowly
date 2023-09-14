package com.skowly.core.domain.model;

import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Classroom extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String roomNumber; // The room number or identifier

	private String building; // Building in which the classroom is located

	private int capacity; // Seating capacity of the room

	private boolean hasProjector; // Does the room have a projector?

	private boolean hasWhiteboard; // Does the room have a whiteboard?

	private boolean isActive;

	private boolean isLaboratory;

	// other fields as needed

	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school; // The school to which the classroom belongs

	@OneToMany(mappedBy = "classroom")
	private List<TimeSlot> timeSlots;
}
