package com.example.restservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restservice.crud.HealthChecklist;

@Repository
public interface HealthChecklistRepository extends JpaRepository<HealthChecklist,Long> {
	Optional<HealthChecklist> findByChildNo(Integer childNo);
}