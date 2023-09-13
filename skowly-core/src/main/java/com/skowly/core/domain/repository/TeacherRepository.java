package com.skowly.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
