package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
