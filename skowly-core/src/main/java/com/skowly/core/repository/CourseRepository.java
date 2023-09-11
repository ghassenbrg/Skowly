package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
