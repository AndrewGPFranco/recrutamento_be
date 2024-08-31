package com.agpf.recrutamento.model;

import com.agpf.recrutamento.enumType.JobType;
import com.agpf.recrutamento.enumType.LevelType;
import com.agpf.recrutamento.enumType.StatusType;
import com.agpf.recrutamento.enumType.TechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.List;

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

    @ElementCollection(targetClass = JobType.class)
    @CollectionTable(name = "job", joinColumns = @JoinColumn(name = "vacancy_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "job")
    private List<JobType> jobType;

    @ElementCollection(targetClass = TechnologyType.class)
    @CollectionTable(name = "technology", joinColumns = @JoinColumn(name = "vacancy_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "technology")
    private List<TechnologyType> technology;

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

    @ElementCollection
    @CollectionTable(name = "benefits", joinColumns = @JoinColumn(name = "vacancy_id"))
    @Column(name = "benefit")
    private List<String> benefits;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    public Vacancy(String title, String description, Integer salary, String company, String location,
                   List<JobType> jobTypes, List<TechnologyType> technology, LevelType levelType,
                   boolean experience, StatusType status, List<String> benefits, LocalDate localDate, LocalDate localDate1)
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
