package com.leads.practice.controller;

import com.leads.practice.dto.LeadDto;
import com.leads.practice.service.LeadService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
public class LeadController {

  private final LeadService service;

  public LeadController(LeadService service) {
    this.service = service;
  }

  @GetMapping
  public List<LeadDto> getAll() {
    return service.getAll();
  }

  @PostMapping
  public LeadDto create(@Valid @RequestBody LeadDto dto) {
    return service.create(dto);
  }

  @GetMapping("/{id}")
  public LeadDto getById(@PathVariable(name = "id") Long id) {
    return service.getById(id);
  }

  @PutMapping("/{id}")
  public LeadDto update(@PathVariable Long id, @RequestBody LeadDto dto) {
    return service.update(id, dto);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable(name = "id") Long id) {
    service.delete(id);
  }
}

