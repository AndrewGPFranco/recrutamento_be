package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.vacancy.VacancyDTO;
import com.agpf.recrutamento.model.Vacancy;
import com.agpf.recrutamento.service.VacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/all")
    public ResponseEntity<List<Vacancy>> getAllVacancy() {
        List<Vacancy> allVacancies = vacancyService.getAllVacancies();
        return ResponseEntity.ok().body(allVacancies);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerVacancy(@Valid @RequestBody VacancyDTO dto) {
        try {
            vacancyService.registerVacancy(dto);
            return ResponseEntity.ok().body("Vaga registrada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Falha ao registrar vaga.");
        }
    }
}
