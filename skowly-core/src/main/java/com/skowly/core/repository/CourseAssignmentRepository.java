package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.CourseAssignment;

public interface CourseAssignmentRepository extends JpaRepository<CourseAssignment, Long> {

}
