package com.longo.anatomy_service.interfaces;

import com.longo.anatomy_service.dto.MuscleDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.entity.MuscleExcercise;

import java.util.List;
import java.util.UUID;

public interface Muscleinterface {

    List<MuscleDto> findAll();
    MuscleDto findById(UUID uuid);
    List<MuscleExerciseWithExerciseDto> findAllByExerciseId(UUID id);
}
