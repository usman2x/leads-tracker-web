package com.leads.practice.service;
import com.leads.practice.dto.LeadDto;
import com.leads.practice.exception.DuplicateEmailException;
import com.leads.practice.mapper.LeadMapper;
import com.leads.practice.repository.LeadRepository;
import com.leads.practice.utils.ValidationUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadService {

  private final LeadRepository repo;
  private final LeadMapper mapper;
  private final ValidationUtils validationUtils;

  public LeadService(LeadRepository repo, LeadMapper mapper, ValidationUtils validationUtils) {
    this.repo = repo;
    this.mapper = mapper;
    this.validationUtils = validationUtils;
  }

  public List<LeadDto> getAll() {
    return repo.findAll().stream()
        .map(mapper::toDto)
        .toList();
  }

  public LeadDto getById(Long id) {
    return repo.findById(id)
        .map(mapper::toDto)
        .orElseThrow(() -> new RuntimeException("Lead not found"));
  }

  public LeadDto create(LeadDto dto) {
    validationUtils.validateUniqueEmail(dto.email());

    var saved = repo.save(mapper.toEntityForCreate(dto));
    return mapper.toDto(saved);
  }

  public LeadDto update(Long id, LeadDto dto) {
    if (!repo.existsById(id)) throw new RuntimeException("Lead not found");
    var updated = repo.save(mapper.toEntity(new LeadDto(id, dto.name(), dto.email())));
    return mapper.toDto(updated);
  }

  public void delete(Long id) {
    if (!repo.existsById(id)) throw new RuntimeException("Lead not found");
    repo.deleteById(id);
  }
}
