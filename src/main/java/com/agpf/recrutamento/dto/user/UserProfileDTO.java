package com.agpf.recrutamento.dto.user;

import com.agpf.recrutamento.enumType.TechnologyType;
import com.agpf.recrutamento.model.profile.Experience;

import java.util.Date;
import java.util.List;

public record UserProfileDTO(
    Long userId,
    String nickname,
    String fullName,
    String description,
    Date dateOfBirth,
    List<TechnologyType> stack,
    List<Experience> experience,
    String country,
    String city,
    String gender,
    String phoneNumber,
    List<String> languages
) {}
