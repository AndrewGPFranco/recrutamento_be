package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.model.profile.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
