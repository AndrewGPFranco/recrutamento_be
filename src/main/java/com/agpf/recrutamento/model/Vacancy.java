package com.agpf.recrutamento.model;

import com.agpf.recrutamento.EnumType.JobType;
import com.agpf.recrutamento.EnumType.LevelType;
import com.agpf.recrutamento.EnumType.StatusType;
import com.agpf.recrutamento.EnumType.TechnologyType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
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
    private List<JobType> jobType;

    @NotNull
    @Column(name = "technologies")
    private List<TechnologyType> technologies;

    @NotNull
    @Column(name = "level")
    private LevelType levelType;

    @NotNull
    @Column(name = "experience")
    private boolean experience;

    @Column(name = "status")
    private StatusType status;

    @NotNull
    @Column(name = "benefits")
    private List<String> benefits;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

}
