package com.longo.anatomy_service.entity;

import com.longo.anatomy_service.enums.RuoloAttivazione;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.hibernate.validator.cfg.defs.UUIDDef;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "Muscle_Exercise")
@Data
@NoArgsConstructor
public class MuscleExcercise {

    @EmbeddedId
    private MuscleExerciseId muscleExerciseId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ruolo_attivazione")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private RuoloAttivazione ruoloAttivazione;

    @Column(name = "percentuale_attivazione")
    private BigDecimal percentualeAttivazione;

    @ManyToOne
    @MapsId("muscleId")
    @JoinColumn(name = "muscle_id")
    private Muscle muscle;

    @ManyToOne
    @MapsId("exerciseId")
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;
}
