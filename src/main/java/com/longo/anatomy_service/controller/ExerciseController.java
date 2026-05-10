package com.longo.anatomy_service.controller;

import com.longo.anatomy_service.dto.ExerciseDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithMuscleDto;
import com.longo.anatomy_service.interfaces.ExerciseInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/api")
public class ExerciseController {

    private final ExerciseInterface exerciseInterface;

    @GetMapping("/exercise/all")
    public ResponseEntity<List<ExerciseDto>> list(){
        return ResponseEntity.ok(exerciseInterface.findAll());
    }

    @GetMapping("/exercise/{id}")
    public ResponseEntity<ExerciseDto> findOne(@PathVariable UUID id){
        return ResponseEntity.ok(exerciseInterface.findById(id));
    }

    @GetMapping("/muscles/{id}/exercises")
    public ResponseEntity<List<MuscleExerciseWithMuscleDto>> findMuscles(@PathVariable UUID id){
        return ResponseEntity.ok(exerciseInterface.findAllByMuscleId(id));
    }
}
