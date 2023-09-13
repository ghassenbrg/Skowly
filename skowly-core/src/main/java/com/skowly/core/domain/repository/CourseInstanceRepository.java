package com.skowly.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.CourseInstance;

public interface CourseInstanceRepository extends JpaRepository<CourseInstance, Long> {

}
