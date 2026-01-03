package com.project.Hospital_Management.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DoctorProfileRequest(
        @NotNull Long userId,
        @NotBlank String specialization,
        @NotBlank String qualification,
        @NotBlank String department,
        String availability
) {}
