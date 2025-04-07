package com.leads.practice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LeadDto(
    Long id,
    @NotBlank(message = "Name must not be empty")
    String name,

    @NotBlank(message = "Email must not be empty")
    @Email(message = "Email should be valid")
    String email
) {}