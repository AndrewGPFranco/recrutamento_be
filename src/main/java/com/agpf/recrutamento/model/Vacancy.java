package com.agpf.recrutamento.model;

import com.agpf.recrutamento.EnumType.JobType;
import com.agpf.recrutamento.EnumType.LevelType;
import com.agpf.recrutamento.EnumType.StatusType;
import com.agpf.recrutamento.EnumType.TechnologyType;
import jakarta.persistence.Entity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Vacancy {

    private Long id;
    private String title;
    private String description;
    private BigDecimal salary;
    private String company;
    private String location;
    private List<JobType> jobType;
    private List<TechnologyType> category;
    private LevelType levelType;
    private boolean experience;
    private StatusType status;
    private LocalDate created_at;
    private LocalDate updated_at;
    private List<String> benefits;

}
