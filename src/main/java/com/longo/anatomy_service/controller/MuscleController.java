package com.longo.anatomy_service.controller;

import com.longo.anatomy_service.dto.MuscleDto;
import com.longo.anatomy_service.dto.MuscleExerciseRequestDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.dto.RequestMuscleDto;
import com.longo.anatomy_service.interfaces.MuscleExerciseInterface;
import com.longo.anatomy_service.interfaces.Muscleinterface;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.DeclareError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/api")
public class MuscleController {

    private final Muscleinterface muscleinterface;
    private final MuscleExerciseInterface muscleExerciseInterface;

    @GetMapping("/muscle/all")
    public ResponseEntity<List<MuscleDto>> allMuscles(){
        return ResponseEntity.ok(muscleinterface.findAll());
    }

    @GetMapping("/muscle/{id}")
    public ResponseEntity<MuscleDto> getOne(@PathVariable UUID id){
        return ResponseEntity.ok(muscleinterface.findById(id));
    }

    @GetMapping("/exercise/{id}/muscles")
    public ResponseEntity<List<MuscleExerciseWithExerciseDto>> findEx(@PathVariable UUID id){
        return ResponseEntity.ok(muscleinterface.findAllByExerciseId(id));
    }

    @PostMapping("/muscle")
    public ResponseEntity<MuscleDto> addMuscle(@RequestBody RequestMuscleDto muscleDto){
        return ResponseEntity.ok(muscleinterface.addMuscle(muscleDto));
    }

    @PutMapping("/muscle/{id}")
    public ResponseEntity<MuscleDto> updateMuscle(@PathVariable UUID id, @RequestBody RequestMuscleDto muscleDto){
        return ResponseEntity.ok(muscleinterface.updateMuscle(id, muscleDto));
    }

    @DeleteMapping("/muscle/{id}")
    public ResponseEntity<MuscleDto> deleteMuscle(@PathVariable UUID id){
        return ResponseEntity.ok(muscleinterface.deleteById(id));
    }

    @PostMapping("muscle/{muscleId}/exercise/{exerciseId}")
    public ResponseEntity<?> addRelation(@RequestBody MuscleExerciseRequestDto muscleExerciseRequestDto,
                                         @PathVariable UUID muscleId,
                                         @PathVariable UUID exerciseId){
        return ResponseEntity.ok(muscleExerciseInterface.addRelations(muscleId, exerciseId, muscleExerciseRequestDto));
    }

    @DeleteMapping("muscle/{muscleId}/exercise/{exerciseId}")
    public ResponseEntity<Void> deleteRelation(@PathVariable UUID muscleId,
                                               @PathVariable UUID exerciseId){
        muscleExerciseInterface.deleteRelation(muscleId, exerciseId);
        return ResponseEntity.noContent().build();
    }
}
