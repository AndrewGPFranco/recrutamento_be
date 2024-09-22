package com.agpf.recrutamento.dto.user_profile;

import java.util.Date;
import java.util.List;

import com.agpf.recrutamento.enumType.TechnologyType;

import com.agpf.recrutamento.model.profile.Experience;
import jakarta.validation.constraints.NotNull;

public record UserProfileDTO(
        Long user_id,
        String nickname,
        @NotNull String fullName,
        String description,
        @NotNull Date dateOfBirth,
        List<TechnologyType> stack,
        List<Experience> experience,
        @NotNull String country,
        @NotNull String city,
        @NotNull String gender,
        String phoneNumber,
        List<String> languages
) {}