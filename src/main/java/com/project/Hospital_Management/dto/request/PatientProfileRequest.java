package com.project.Hospital_Management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PatientProfileRequest(
      @NotNull Long userId,
      @NotBlank String bloodGroup,
      @NotBlank String emergencyContact,
      String medicalHistory
) {}
