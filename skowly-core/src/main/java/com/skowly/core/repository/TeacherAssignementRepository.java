package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.TeacherAssignment;

public interface TeacherAssignementRepository extends JpaRepository<TeacherAssignment, Long> {

}
