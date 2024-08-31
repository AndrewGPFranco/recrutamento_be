package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> { }
