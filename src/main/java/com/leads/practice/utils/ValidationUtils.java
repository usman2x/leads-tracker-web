package com.leads.practice.utils;

import com.leads.practice.exception.DuplicateEmailException;
import com.leads.practice.repository.LeadRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtils {

  private final LeadRepository leadRepo;

  public ValidationUtils(LeadRepository leadRepo) {
    this.leadRepo = leadRepo;
  }

  public void validateUniqueEmail(String email) {
    if (leadRepo.existsByEmail(email)) {
      throw new DuplicateEmailException("Email already exists: " + email);
    }
  }
}