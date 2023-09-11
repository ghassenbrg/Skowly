package com.skowly.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skowly.core.model.Classroom;


public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
