package com.agpf.recrutamento.service;

import com.agpf.recrutamento.model.Vacancy;
import com.agpf.recrutamento.util.VacancyFixture;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VacancyServiceTest {

    @Mock
    private VacancyService vacancyService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Teste responsável por listar todas as vagas.")
    public void getAll() {
        Vacancy vacancyJava = VacancyFixture.getVacancy("Desenvolvedor Java");
        Vacancy vacancyCSharp = VacancyFixture.getVacancy("Desenvolvedor CSharp");
        Vacancy vacancyGolang = VacancyFixture.getVacancy("Desenvolvedor Golang");
        List<Vacancy> vacancyList = List.of(vacancyJava, vacancyCSharp, vacancyGolang);

        Mockito.when(vacancyService.getAll()).thenReturn(vacancyList);

        List<Vacancy> result = vacancyService.getAll();

        assertEquals(3, result.size());
        for (Vacancy entry : result) {
            assertTrue(result.contains(entry));
        }
    }
}