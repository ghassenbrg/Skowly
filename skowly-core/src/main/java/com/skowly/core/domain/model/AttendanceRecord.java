package com.skowly.core.domain.model;

import java.util.Date;

import com.skowly.core.domain.model.base.SchoolAwareEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class AttendanceRecord extends SchoolAwareEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "timeSlot_id")
	private TimeSlot timeSlot;

	@ManyToOne
	@JoinColumn(name = "enrollment_id")
	private Enrollment enrollment;

	@Enumerated(EnumType.STRING)
	private AttendanceStatus status; // Enum for attendance status

	private String notes; // Optional notes for any exceptions or additional information

	@Temporal(TemporalType.DATE)
	private Date attendanceDate; // The date of attendance

}

enum AttendanceStatus {
	PRESENT, ABSENT, LATE, EXCUSED
}
