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
import java.util.Optional;

@Service
public class VacancyService {

    private static final Logger logger = LoggerFactory.getLogger(VacancyService.class);

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private WrapperDtoEntity wrapperDtoEntity;

    public List<Vacancy> getAll() {
        return vacancyRepository.findAll();
    }

    public void register(@Valid VacancyDTO dto) throws RuntimeException {
        try {
            Vacancy vacancy = wrapperDtoEntity.vacancyDtoToEntity(dto);
            vacancyRepository.save(vacancy);
        } catch (RuntimeException e) {
            logger.error("Erro ao registrar vaga", e);
            throw new RegisterException(e.getMessage());
        }
    }

    public void delete(Long id) {
        Optional<Vacancy> vacancy = getById(id);
        vacancyRepository.deleteById(id);
    }

    public Optional<Vacancy> getById(Long id) {
        return Optional.ofNullable(vacancyRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao encontrar vaga com id " + id + ".")));
    }
}
