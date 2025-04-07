package com.leads.practice.mapper;

import com.leads.practice.dto.LeadDto;
import com.leads.practice.model.Lead;
import org.springframework.stereotype.Component;

@Component
public class LeadMapper {

  public LeadDto toDto(Lead lead) {
    return new LeadDto(lead.getId(), lead.getName(), lead.getEmail());
  }

  public Lead toEntityForCreate(LeadDto dto) {
    return new Lead(null, dto.name(), dto.email());
  }

  public Lead toEntity(LeadDto dto) {
    return new Lead(dto.id(), dto.name(), dto.email());
  }
}