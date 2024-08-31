package com.agpf.recrutamento.dto.vacancy;

import com.agpf.recrutamento.enumType.JobType;
import com.agpf.recrutamento.enumType.LevelType;
import com.agpf.recrutamento.enumType.StatusType;
import com.agpf.recrutamento.enumType.TechnologyType;

import java.time.LocalDate;
import java.util.List;

public record VacancyDTO(
        String title,
        String description,
        Integer salary,
        String company,
        String location,
        List<JobType> jobType,
        List<TechnologyType> technology,
        LevelType levelType,
        boolean experience,
        StatusType status,
        List<String> benefits,
        LocalDate created_at,
        LocalDate updated_at
) {}