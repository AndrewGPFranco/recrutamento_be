package com.agpf.recrutamento.service;

import com.agpf.recrutamento.dto.vacancy.VacancyDTO;
import com.agpf.recrutamento.dto.wrapper.WrapperDtoEntity;
import com.agpf.recrutamento.exception.RegisterException;
import com.agpf.recrutamento.model.Vacancy;
import com.agpf.recrutamento.repository.VacancyRepository;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {

    private static final Logger logger = LoggerFactory.getLogger(VacancyService.class);

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private WrapperDtoEntity wrapperDtoEntity;

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }

    public void registerVacancy(@Valid VacancyDTO dto) throws RuntimeException {
        try {
            Vacancy vacancy = wrapperDtoEntity.vacancyDtoToEntity(dto);
            vacancyRepository.save(vacancy);
        } catch (RuntimeException e) {
            logger.error("Erro ao registrar vaga", e);
            throw new RegisterException(e.getMessage());
        }
    }
}
