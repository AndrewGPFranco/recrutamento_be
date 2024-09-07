package com.agpf.recrutamento.dto.employee;

import com.agpf.recrutamento.enumType.HierarchyType;
import jakarta.validation.constraints.NotNull;

public record EmployeeHierarchyDTO(
        @NotNull String label,
        @NotNull EmployeeDTO employeeDTO,
        @NotNull HierarchyType hierarchyType
) {}
