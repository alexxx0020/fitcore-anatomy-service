package com.longo.anatomy_service.service;

import com.longo.anatomy_service.dto.ExerciseDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithMuscleDto;
import com.longo.anatomy_service.entity.Exercise;
import com.longo.anatomy_service.exception.ItemNotFoundException;
import com.longo.anatomy_service.interfaces.ExerciseInterface;
import com.longo.anatomy_service.repository.ExerciseRepository;
import com.longo.anatomy_service.repository.MuscleExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExerciseService implements ExerciseInterface {

    private final ModelMapper modelMapper;
    private final ExerciseRepository exerciseRepository;
    private final MuscleExerciseRepository muscleExerciseRepository;

    @Override
    public List<ExerciseDto> findAll() {
        return exerciseRepository.findAll().stream()
                .map(ex -> modelMapper.map(ex, ExerciseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ExerciseDto findById(UUID id) {
        Exercise exercise = exerciseRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("Nessun esercizio presente con questo id {}" + id)
        );

        return modelMapper.map(exercise, ExerciseDto.class);
    }

    @Override
    public List<MuscleExerciseWithMuscleDto> findAllByMuscleId(UUID id) {
        return muscleExerciseRepository.findAllByMuscleId(id).stream()
                .map(me -> modelMapper.map(me, MuscleExerciseWithMuscleDto.class))
                .toList();
    }
}
