package com.agpf.recrutamento.util;

import com.agpf.recrutamento.enumType.JobType;
import com.agpf.recrutamento.enumType.LevelType;
import com.agpf.recrutamento.enumType.StatusType;
import com.agpf.recrutamento.enumType.TechnologyType;
import com.agpf.recrutamento.model.Vacancy;

import java.time.LocalDate;
import java.util.List;

public class VacancyFixture {

    public static Vacancy getVacancy(String title) {
        return new Vacancy(title, "Vaga destinada a novos desenvolvedores",
                5000, "Gpf Company", "Cidade de São Paulo", List.of(JobType.HYBRID),
                List.of(TechnologyType.JAVA, TechnologyType.VUE), LevelType.JR, false, StatusType.ONGOING,
                List.of("Vale-Refeição"), LocalDate.now(), LocalDate.now());
    }
}
