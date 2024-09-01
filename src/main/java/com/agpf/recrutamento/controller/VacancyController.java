package com.agpf.recrutamento.controller;

import com.agpf.recrutamento.dto.vacancy.VacancyDTO;
import com.agpf.recrutamento.exception.RegisterException;
import com.agpf.recrutamento.model.Vacancy;
import com.agpf.recrutamento.service.VacancyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacancy")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @GetMapping("/all")
    public ResponseEntity<List<Vacancy>> getAllVacancy() {
        List<Vacancy> allVacancies = vacancyService.getAll();
        return ResponseEntity.ok().body(allVacancies);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerVacancy(@Valid @RequestBody VacancyDTO dto) {
        try {
            vacancyService.register(dto);
            return ResponseEntity.ok().body("Vaga registrada com sucesso.");
        } catch (RegisterException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteVacancyById(@PathVariable Long id) {
        try {
            vacancyService.delete(id);
            return ResponseEntity.ok("Vaga excluída com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getVacancyById(@PathVariable Long id) {
        try {
            Optional<Vacancy> vacancyById = vacancyService.getById(id);
            return ResponseEntity.ok().body(vacancyById);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateVacancyById(@PathVariable Long id, @Valid @RequestBody VacancyDTO dto) {
        try {
            vacancyService.update(id, dto);
            return ResponseEntity.ok().body("Vaga atualizada com sucesso.");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
