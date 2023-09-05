package com.skowly.core.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.model.school.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
    // You can define custom query methods here if needed
}