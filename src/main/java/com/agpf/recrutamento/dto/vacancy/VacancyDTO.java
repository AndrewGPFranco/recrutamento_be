package com.agpf.recrutamento.dto.vacancy;

import com.agpf.recrutamento.EnumType.JobType;
import com.agpf.recrutamento.EnumType.LevelType;
import com.agpf.recrutamento.EnumType.StatusType;
import com.agpf.recrutamento.EnumType.TechnologyType;

import java.time.LocalDate;

public record VacancyDTO(
        String title,
        String description,
        Integer salary,
        String company,
        String location,
        JobType jobType,
        TechnologyType technology,
        LevelType levelType,
        boolean experience,
        StatusType status,
        String benefits,
        LocalDate created_at,
        LocalDate updated_at
) {}