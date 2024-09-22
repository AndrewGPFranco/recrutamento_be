package com.agpf.recrutamento.model.profile;

import com.agpf.recrutamento.enumType.TechnologyType;
import com.agpf.recrutamento.model.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profiles")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;

    @NotNull
    @NotBlank
    @Column(name = "nickname", unique = true)
    private String nickname;

    @NotNull
    @NotBlank
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "date_birth")
    private Date dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "technology_type")
    @ElementCollection(targetClass = TechnologyType.class)
    @CollectionTable(name = "profile_stacks", joinColumns = @JoinColumn(name = "profile_id"))
    private List<TechnologyType> stack;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
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

    @NotNull
    @NotBlank
    @Column(name = "phone_number")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{5}-\\d{4}")
    private String phoneNumber;

    @ElementCollection
    @Column(name = "language")
    @CollectionTable(name = "profile_languages", joinColumns = @JoinColumn(name = "profile_id"))
    private List<String> languages;

    public Profile(User user, String nickname, String fullName, String description, Date dateOfBirth, List<TechnologyType> stack, List<Experience> experience, String country, String city, String gender, String phoneNumber, List<String> languages) {
        this.user = user;
        this.nickname = nickname;
        this.fullName = fullName;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.stack = stack;
        this.experience = experience;
        this.country = country;
        this.city = city;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.languages = languages;
    }
}
