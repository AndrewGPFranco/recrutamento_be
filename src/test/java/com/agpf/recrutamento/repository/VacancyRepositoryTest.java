package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.enumType.JobType;
import com.agpf.recrutamento.enumType.LevelType;
import com.agpf.recrutamento.enumType.StatusType;
import com.agpf.recrutamento.enumType.TechnologyType;
import com.agpf.recrutamento.model.Vacancy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class VacancyRepositoryTest {

    @Autowired
    private VacancyRepository vacancyRepository;

    @Test
    @DisplayName("Teste responsável por deletar vaga em cascade")
    void deleteById() {
        Vacancy vacancy = new Vacancy("Desenvolvedor Java", "Vaga destinada a novos desenvolvedores",
                5000, "Gpf Company", "Cidade de São Paulo", List.of(JobType.HYBRID),
                List.of(TechnologyType.JAVA, TechnologyType.VUE), LevelType.JR, false, StatusType.ONGOING,
                List.of("Vale-Refeição"), LocalDate.now(), LocalDate.now());

        vacancyRepository.save(vacancy);
        vacancyRepository.deleteById(vacancy.getId());

        assertFalse(vacancyRepository.findById(1L).isPresent());
    }
}