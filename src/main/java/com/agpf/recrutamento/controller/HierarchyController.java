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

    @DeleteMapping("/removeEdge")
    public void removeAllEdges(@RequestParam String id) {
        hierarchyService.removeAllEdges(id);
    }

    @GetMapping("/getHierarchyByEmployee/{id}")
    public EmployeeHierarchyDTO getHierarchyByEmployee(@PathVariable String id) {
        return hierarchyService.getHierarchyByEmployee(id);
    }

    @PutMapping("/update/{id}")
    public void updateHierarchyByEmployee(@PathVariable String id, @RequestBody Map<String, String> body) {
        hierarchyService.updateHierarchyOfEmployee(id, body.get("name"), body.get("hierarchy"));
    }
}
