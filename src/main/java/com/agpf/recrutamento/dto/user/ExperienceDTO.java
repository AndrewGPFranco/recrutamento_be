package com.agpf.recrutamento.dto.user;

import java.util.Date;

public record ExperienceDTO(
   String companyName,
   Date startDate,
   Date endDate,
   String description
) {}
