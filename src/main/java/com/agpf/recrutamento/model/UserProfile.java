package com.agpf.recrutamento.model;

import com.agpf.recrutamento.dto.user.ExperienceDTO;
import com.agpf.recrutamento.enumType.TechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.regex.qual.Regex;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user_profile")
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String surname;

    @NotNull
    @NotBlank
    private String fullName;

    private String description;

    @NotNull
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    private List<TechnologyType> stack;

    private List<ExperienceDTO> experience;

    @NotNull
    @NotBlank
    private String country;

    @NotNull
    @NotBlank
    private String city;

    @NotNull
    @NotBlank
    @Pattern(regexp = "MASCULINO|FEMININO|OUTRO", message = "O gênero deve ser 'MASCULINO', 'FEMININO' ou 'OUTRO'")
    private String gender;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
    private String phoneNumber;

    @NotNull
    @NotBlank
    private List<String> languages;

}
