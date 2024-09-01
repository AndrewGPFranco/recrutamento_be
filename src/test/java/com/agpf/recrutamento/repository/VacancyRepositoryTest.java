package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.model.Vacancy;
import com.agpf.recrutamento.util.VacancyFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VacancyRepositoryTest {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Test
    @DisplayName("Teste responsável por deletar vaga em cascade")
    void deleteById() {
        Vacancy vacancy = VacancyFixture.getVacancy("Desenvolvedor Java");

        vacancyRepository.save(vacancy);
        vacancyRepository.deleteById(vacancy.getId());

        assertFalse(vacancyRepository.findById(1L).isPresent());
    }
}