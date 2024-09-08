package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.employee.EmployeeHierarchyDTO;
import com.agpf.recrutamento.service.HierarchyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/hierarchy")
public class HierarchyController {

    @Autowired
    private HierarchyService hierarchyService;

    @PostMapping("/addEdge")
    public void addEmployeeEdgeToHierarchy(@RequestBody @Valid EmployeeHierarchyDTO dto) {
        hierarchyService.addEmployeeEdgeToHierarchy(dto.label(), dto.employeeDTO(), dto.hierarchyType());
    }

    @PostMapping("/removeEdge")
    public void removeAllEdges(@RequestBody Map<String, String> body) {
        String fromLabelClass = body.get("fromLabelClass");
        String fromPropertyKey = body.get("fromPropertyKey");
        String fromValueProperty = body.get("fromValueProperty");
        String labelEdge = body.get("labelEdge");
        String toLabelClass = body.get("toLabelClass");
        String toPropertyKey = body.get("toPropertyKey");
        String toValueProperty = body.get("toValueProperty");

        hierarchyService.removeAllEdges(fromLabelClass, fromPropertyKey, fromValueProperty, labelEdge, toLabelClass, toPropertyKey, toValueProperty);
    }
}
