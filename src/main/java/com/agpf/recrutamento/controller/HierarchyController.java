package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.employee.EmployeeHierarchyDTO;
import com.agpf.recrutamento.enumType.HierarchyType;
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

        hierarchyService.removeAllEdges(fromLabelClass, fromPropertyKey, fromValueProperty, labelEdge, toLabelClass);
    }

    @GetMapping("/getHierarchyByEmployee/{id}")
    public EmployeeHierarchyDTO getHierarchyByEmployee(@PathVariable String id) {
        return hierarchyService.getHierarchyByEmployee(id);
    }

    @PostMapping("/update/{id}")
    public void updateHierarchyByEmployee(@PathVariable String id, @RequestBody Map<String, String> body) {
        hierarchyService.updateHierarchyOfEmployee(id, body.get("name"), body.get("hierarchy"));
    }
}
