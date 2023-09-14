package com.skowly.core.domain.model;

import java.util.Date;
import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TimeTable extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String semester; // The academic semester or term

	@Temporal(TemporalType.DATE)
	private Date validFrom; // Start date

	@Temporal(TemporalType.DATE)
	private Date validUntil; // End date

	private boolean isActive; // Is the timetable currently active?

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUpdated; // Last modification timestamp

	@OneToOne(mappedBy = "timeTable")
	private ClassGroup classGroup; // The related ClassGroup entity

	@OneToMany(mappedBy = "timeTable")
	private List<TimeSlot> timeSlots; // List of TimeSlots for this timetable

}
