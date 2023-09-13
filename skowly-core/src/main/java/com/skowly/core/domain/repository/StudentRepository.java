package com.skowly.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
