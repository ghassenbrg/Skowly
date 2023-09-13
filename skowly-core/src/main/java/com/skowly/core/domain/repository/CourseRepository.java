package com.skowly.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
