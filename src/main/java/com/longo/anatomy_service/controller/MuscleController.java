package com.longo.anatomy_service.controller;

import com.longo.anatomy_service.dto.MuscleDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.interfaces.Muscleinterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
public class MuscleController {

    private final Muscleinterface muscleinterface;

    @GetMapping("/muscle/all")
    public ResponseEntity<List<MuscleDto>> allMuscles(){
        return ResponseEntity.ok(muscleinterface.findAll());
    }

    @GetMapping("/muscle/{id}")
    public ResponseEntity<MuscleDto> getOne(@PathVariable UUID id){
        return ResponseEntity.ok(muscleinterface.findById(id));
    }

    @GetMapping("/exercise/{id}/muscles")
    private ResponseEntity<List<MuscleExerciseWithExerciseDto>> findEx(@PathVariable UUID id){
        return ResponseEntity.ok(muscleinterface.findAllByExerciseId(id));
    }
}
