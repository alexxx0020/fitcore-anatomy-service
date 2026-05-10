package com.longo.anatomy_service.repository;

import com.longo.anatomy_service.entity.MuscleExcercise;
import com.longo.anatomy_service.entity.MuscleExerciseId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MuscleExerciseRepository extends JpaRepository<MuscleExcercise, MuscleExerciseId> {

    @Query("SELECT me FROM MuscleExcercise me WHERE me.muscle.muscleId = :muscleId")
    List<MuscleExcercise> findAllByMuscleId(@Param("muscleId") UUID muscleId);

    @Query("SELECT me FROM MuscleExcercise me WHERE me.exercise.exerciseId = :exerciseId")
    List<MuscleExcercise> findAllByExerciseId(@Param("exerciseId") UUID exerciseId);
}
