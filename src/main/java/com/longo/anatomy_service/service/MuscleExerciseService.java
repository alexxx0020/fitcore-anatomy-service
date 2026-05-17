package com.longo.anatomy_service.service;

import com.longo.anatomy_service.dto.MuscleExerciseRequestDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithMuscleDto;
import com.longo.anatomy_service.entity.Exercise;
import com.longo.anatomy_service.entity.Muscle;
import com.longo.anatomy_service.entity.MuscleExcercise;
import com.longo.anatomy_service.entity.MuscleExerciseId;
import com.longo.anatomy_service.exception.ItemNotFoundException;
import com.longo.anatomy_service.interfaces.MuscleExerciseInterface;
import com.longo.anatomy_service.repository.ExerciseRepository;
import com.longo.anatomy_service.repository.MuscleExerciseRepository;
import com.longo.anatomy_service.repository.MuscleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MuscleExerciseService implements MuscleExerciseInterface {

    private final MuscleExerciseRepository muscleExerciseRepository;
    private final MuscleRepository muscleRepository;
    private final ExerciseRepository exerciseRepository;
    private final ModelMapper modelMapper;

    @Override
    public MuscleExerciseWithExerciseDto addRelations(UUID idMuscle, UUID idExercise, MuscleExerciseRequestDto dto) {
        Muscle muscle = muscleRepository.findById(idMuscle).orElseThrow(
                () -> new ItemNotFoundException("Muscolo non trovato con id " + idMuscle)
        );

        Exercise exercise = exerciseRepository.findById(idExercise).orElseThrow(
                () -> new ItemNotFoundException("Esercizio non trovato con id " + idExercise)
        );

        MuscleExerciseId id = new MuscleExerciseId();
        id.setMuscleId(idMuscle);
        id.setExerciseId(idExercise);

        MuscleExcercise relation = new MuscleExcercise();
        relation.setMuscleExerciseId(id);
        relation.setMuscle(muscle);
        relation.setExercise(exercise);
        relation.setRuoloAttivazione(dto.getRuoloAttivazione());
        relation.setPercentualeAttivazione(dto.getPercentualeAttivazione());

        MuscleExcercise saved = muscleExerciseRepository.save(relation);
        return modelMapper.map(saved, MuscleExerciseWithExerciseDto.class);
    }

    @Override
    public void deleteRelation(UUID idMuscle, UUID idExercise) {
        MuscleExerciseId id = new MuscleExerciseId();
        id.setMuscleId(idMuscle);
        id.setExerciseId(idExercise);

        if (!muscleExerciseRepository.existsById(id)) {
            throw new ItemNotFoundException("Relazione non trovata");
        }

        muscleExerciseRepository.deleteById(id);
    }
}
