package com.skowly.core.domain.model;

import java.util.Date;
import java.util.List;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class TimeSlot extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "timeTable_id")
	private TimeTable timeTable;

	@OneToMany(mappedBy = "timeSlot", cascade = CascadeType.ALL)
	private List<AttendanceRecord> attendanceRecords;

	@ManyToOne
	@JoinColumn(name = "classRoom_id")
	private Classroom classroom;
	
	@ManyToOne
	@JoinColumn(name = "courseInstance_id")
	private CourseInstance courseInstance;

	private String dayOfWeek; // Day of the week (e.g., "Monday", "Tuesday")

	@Temporal(TemporalType.TIME)
	private Date startTime; // Start time of the time slot

	@Temporal(TemporalType.TIME)
	private Date endTime; // End time of the time slot

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private CourseInstance subject; // Subject being taught

	private boolean isLaboratory; // Is this a laboratory session?

	@Enumerated(EnumType.STRING)
	private TimeSlotStatus status; // Status of the time slot (Scheduled, Ongoing, Completed, Cancelled)

	private String notes; // Any additional notes
}

enum TimeSlotStatus {
	SCHEDULED, ONGOING, COMPLETED, CANCELLED
}