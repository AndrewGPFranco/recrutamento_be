package com.agpf.recrutamento.model;

import com.agpf.recrutamento.EnumType.JobType;
import com.agpf.recrutamento.EnumType.LevelType;
import com.agpf.recrutamento.EnumType.StatusType;
import com.agpf.recrutamento.EnumType.TechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vacancies")
@Entity(name = "vacancies")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "title")
    @Length(min = 5, max = 30)
    private String title;

    @NotNull
    @Column(name = "description")
    @Length(min = 10, max = 500)
    private String description;

    @Min(1)
    @NotNull
    @Column(name = "salary")
    private Integer salary;

    @NotNull
    @Column(name = "company")
    @Length(min = 3, max = 30)
    private String company;

    @NotNull
    @Column(name = "location")
    @Length(min = 10, max = 50)
    private String location;

    @NotNull
    @Column(name = "job")
    @Enumerated(EnumType.STRING)
    private JobType jobType;

    @NotNull
    @Column(name = "technology")
    @Enumerated(EnumType.STRING)
    private TechnologyType technology;

    @NotNull
    @Column(name = "level")
    @Enumerated(EnumType.STRING)
    private LevelType levelType;

    @NotNull
    @Column(name = "experience")
    private boolean experience;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusType status;

    @NotNull
    @Column(name = "benefits")
    @Length(min = 1, max = 500)
    private String benefits;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    public Vacancy(String title, String description, Integer salary, String company, String location,
                   JobType jobTypes, TechnologyType technology, LevelType levelType,
                   boolean experience, StatusType status, String benefits, LocalDate localDate, LocalDate localDate1)
    {
        this.title = title;
        this.description = description;
        this.salary = salary;
        this.company = company;
        this.location = location;
        this.jobType = jobTypes;
        this.technology = technology;
        this.levelType = levelType;
        this.experience = experience;
        this.status = status;
        this.benefits = benefits;
        this.created_at = localDate;
        this.updated_at = localDate1;
    }
}
