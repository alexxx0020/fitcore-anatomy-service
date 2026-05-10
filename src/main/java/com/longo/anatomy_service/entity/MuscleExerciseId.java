package com.longo.anatomy_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.cfg.defs.UUIDDef;

import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
@NoArgsConstructor
public class MuscleExerciseId implements Serializable {
    @Column(name = "muscle_id")
    private UUID muscleId;

    @Column(name = "exercise_id")
    private UUID exerciseId;
}
