package com.agpf.recrutamento.dto.employee;

import jakarta.validation.constraints.NotNull;

public record EmployeeDTO(
        @NotNull String id,
        @NotNull String name
) {}