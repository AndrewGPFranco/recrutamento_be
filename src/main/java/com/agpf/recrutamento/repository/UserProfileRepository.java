package com.agpf.recrutamento.repository;

import com.agpf.recrutamento.model.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<Profile, Long> {
}
