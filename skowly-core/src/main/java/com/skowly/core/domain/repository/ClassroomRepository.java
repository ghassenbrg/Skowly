package com.skowly.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.AcademicClass;


public interface ClassroomRepository extends JpaRepository<AcademicClass, Long> {

}
