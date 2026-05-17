package com.longo.anatomy_service.interfaces;

import com.longo.anatomy_service.dto.MuscleExerciseRequestDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;

import java.util.UUID;

public interface MuscleExerciseInterface {

    MuscleExerciseWithExerciseDto addRelations(UUID idMuscle, UUID idExercise, MuscleExerciseRequestDto dto);
    void deleteRelation(UUID idMuscle, UUID idExercise);
}
