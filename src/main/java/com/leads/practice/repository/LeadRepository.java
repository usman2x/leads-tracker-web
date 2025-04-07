package com.leads.practice.repository;

import com.leads.practice.model.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Long> {
  boolean existsByEmail(String email);
}