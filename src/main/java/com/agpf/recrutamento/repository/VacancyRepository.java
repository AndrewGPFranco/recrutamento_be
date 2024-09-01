package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.model.Vacancy;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {

    void deleteById(@Param("id") Long id);
}