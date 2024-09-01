package com.agpf.recrutamento.service;

import com.agpf.recrutamento.dto.vacancy.VacancyDTO;
import com.agpf.recrutamento.dto.wrapper.WrapperDtoEntity;
import com.agpf.recrutamento.exception.RegisterException;
import com.agpf.recrutamento.model.Vacancy;
import com.agpf.recrutamento.repository.VacancyRepository;
import com.agpf.recrutamento.util.Utils;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        getById(id);
        vacancyRepository.deleteById(id);
    }

    public Optional<Vacancy> getById(Long id) {
        return Optional.ofNullable(vacancyRepository.findById(id).orElseThrow(() -> new RuntimeException("Erro ao encontrar vaga com id " + id + ".")));
    }

    public void update(Long id, @Valid VacancyDTO dto) {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vaga não encontrada."));

        Utils.updateField(dto.title(), vacancy::setTitle);
        Utils.updateField(dto.description(), vacancy::setDescription);
        Utils.updateField(dto.salary(), vacancy::setSalary);
        Utils.updateField(dto.company(), vacancy::setCompany);
        Utils.updateField(dto.location(), vacancy::setLocation);
        Utils.updateField(dto.jobType(), vacancy::setJobType);
        Utils.updateField(dto.experience(), vacancy::setExperience);
        Utils.updateField(dto.technology(), vacancy::setTechnology);
        Utils.updateField(dto.levelType(), vacancy::setLevelType);
        Utils.updateField(dto.status(), vacancy::setStatus);
        Utils.updateField(dto.benefits(), vacancy::setBenefits);
        Utils.updateField(LocalDate.now(), vacancy::setUpdated_at);

        vacancyRepository.save(vacancy);
    }
}
