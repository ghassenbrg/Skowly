package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.CourseAssignment;

public interface CourseAssignementRepository extends JpaRepository<CourseAssignment, Long> {

}
