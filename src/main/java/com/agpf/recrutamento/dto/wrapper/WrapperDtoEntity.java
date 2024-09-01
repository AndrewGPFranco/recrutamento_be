package com.agpf.recrutamento.dto.wrapper;

import com.agpf.recrutamento.dto.vacancy.VacancyDTO;
import com.agpf.recrutamento.model.Vacancy;
import org.springframework.stereotype.Component;

@Component
public class WrapperDtoEntity {

    public Vacancy vacancyDtoToEntity(VacancyDTO dto) {
        return new Vacancy(dto.title(),
                dto.description(),
                dto.salary(),
                dto.company(),
                dto.location(),
                dto.jobType(),
                dto.technology(),
                dto.levelType(),
                dto.experience(),
                dto.status(),
                dto.benefits(),
                dto.created_at(),
                dto.updated_at()
        );
    }

    public VacancyDTO vacancyEntityToDto(Vacancy entity) {
        return new VacancyDTO(entity.getTitle(),
                entity.getDescription(),
                entity.getSalary(),
                entity.getCompany(),
                entity.getLocation(),
                entity.getJobType(),
                entity.getTechnology(),
                entity.getLevelType(),
                entity.isExperience(),
                entity.getStatus(),
                entity.getBenefits(),
                entity.getCreated_at(),
                entity.getUpdated_at()
        );
    }
}
