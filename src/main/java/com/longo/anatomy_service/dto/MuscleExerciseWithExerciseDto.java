package com.longo.anatomy_service.dto;

import com.longo.anatomy_service.enums.RuoloAttivazione;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class MuscleExerciseWithExerciseDto {

    private ExerciseDto exercise;

    private RuoloAttivazione ruoloAttivazione;

    private BigDecimal percentualeAttivazione;
}

