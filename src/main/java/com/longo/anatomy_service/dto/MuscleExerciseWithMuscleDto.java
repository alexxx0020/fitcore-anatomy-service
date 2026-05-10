package com.longo.anatomy_service.dto;

import com.longo.anatomy_service.enums.RuoloAttivazione;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
public class MuscleExerciseWithMuscleDto {

    private MuscleDto muscle;

    private RuoloAttivazione ruoloAttivazione;

    private BigDecimal percentualeAttivazione;
}
