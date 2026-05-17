package com.longo.anatomy_service.dto;

import com.longo.anatomy_service.enums.RuoloAttivazione;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class MuscleExerciseRequestDto {

    @NotNull(message = "il ruolo attivazione è obbligatorio")
    private RuoloAttivazione ruoloAttivazione;

    @NotNull(message = "La percentuale attivazione è obbligatoria")
    private BigDecimal percentualeAttivazione;


}
