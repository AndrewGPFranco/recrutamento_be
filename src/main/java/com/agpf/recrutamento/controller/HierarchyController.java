package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.employee.EmployeeDTO;
import com.agpf.recrutamento.dto.employee.EmployeeHierarchyDTO;
import com.agpf.recrutamento.enumType.HierarchyType;
import com.agpf.recrutamento.service.HierarchyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hierarchy")
public class HierarchyController {

    @Autowired
    private HierarchyService hierarchyService;

    @PostMapping("/addEdge")
    public void addEmployeeEdgeToHierarchy(@RequestBody @Valid EmployeeHierarchyDTO dto) {
        hierarchyService.addEmployeeEdgeToHierarchy(dto.label(), dto.employeeDTO(), dto.hierarchyType());
    }
}
