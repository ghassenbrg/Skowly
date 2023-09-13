package com.skowly.core.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skowly.core.domain.model.School;

public interface SchoolRepository extends JpaRepository<School, Long> {
    // You can define custom query methods here if needed
}