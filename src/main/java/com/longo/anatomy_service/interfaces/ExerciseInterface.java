package com.longo.anatomy_service.interfaces;

import com.longo.anatomy_service.dto.ExerciseDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithMuscleDto;
import com.longo.anatomy_service.dto.RequestExerciseDto;

import java.util.List;
import java.util.UUID;

public interface ExerciseInterface {

    List<ExerciseDto> findAll();
    ExerciseDto findById(UUID id);
    List<MuscleExerciseWithMuscleDto> findAllByMuscleId(UUID id);
    ExerciseDto addExercise(RequestExerciseDto exerciseDto);
    ExerciseDto updateExercise(UUID id,RequestExerciseDto exerciseDto);
    ExerciseDto deleteById(UUID id);
}
