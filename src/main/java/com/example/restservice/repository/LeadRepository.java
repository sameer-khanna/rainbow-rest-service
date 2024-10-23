package com.example.restservice.repository;

import com.example.restservice.crud.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, String> {
}
