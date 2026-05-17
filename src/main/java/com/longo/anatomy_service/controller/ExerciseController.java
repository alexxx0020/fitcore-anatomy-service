package com.longo.anatomy_service.controller;

import com.longo.anatomy_service.dto.*;
import com.longo.anatomy_service.interfaces.ExerciseInterface;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/exercise")
    public ResponseEntity<ExerciseDto> addExercise(@Valid @RequestBody RequestExerciseDto exerciseDto){
        return ResponseEntity.ok(exerciseInterface.addExercise(exerciseDto));
    }

    @PutMapping("/exercise/{id}")
    public ResponseEntity<ExerciseDto> updateExercise(@PathVariable UUID id ,@Valid @RequestBody RequestExerciseDto exerciseDto){
        return ResponseEntity.ok(exerciseInterface.updateExercise(id,exerciseDto));
    }

    @DeleteMapping("/exercise/{id}")
    public ResponseEntity<ExerciseDto> deleteExercise(@PathVariable UUID id){
        return ResponseEntity.ok(exerciseInterface.deleteById(id));
    }}
