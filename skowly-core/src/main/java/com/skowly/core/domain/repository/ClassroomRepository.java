package com.skowly.core.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.Classroom;


public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
