package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
