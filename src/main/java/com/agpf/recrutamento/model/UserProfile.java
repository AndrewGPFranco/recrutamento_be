package com.agpf.recrutamento.model;

import com.agpf.recrutamento.enumType.TechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotNull
    @Column(name = "user_id", unique = true)
    private Long user_id;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @NotNull
    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "date_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = TechnologyType.class)
    private List<TechnologyType> stack;

    @ManyToMany
    @JoinTable(
            name = "user_profile_experience",
            joinColumns = @JoinColumn(name = "user_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "experience_id")
    )
    private List<Experience> experience;

    @NotNull
    @NotBlank
    @Column(name = "country")
    private String country;

    @NotNull
    @NotBlank
    @Column(name = "city")
    private String city;

    @NotNull
    @NotBlank
    @Column(name = "gender")
    @Pattern(regexp = "MASCULINO|FEMININO|OUTRO", message = "O gênero deve ser 'MASCULINO', 'FEMININO' ou 'OUTRO'")
    private String gender;

    @Column(name = "phone_number")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
    private String phoneNumber;

    @ElementCollection
    private List<String> languages;

}
