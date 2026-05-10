package com.longo.anatomy_service.service;

import com.longo.anatomy_service.dto.ExerciseDto;
import com.longo.anatomy_service.dto.MuscleDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithMuscleDto;
import com.longo.anatomy_service.dto.RequestExerciseDto;
import com.longo.anatomy_service.entity.Exercise;
import com.longo.anatomy_service.entity.Muscle;
import com.longo.anatomy_service.exception.ItemNotFoundException;
import com.longo.anatomy_service.exception.RequestNotValidException;
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
                () -> new ItemNotFoundException("Nessun elemento presente con id " + id)
        );

        return modelMapper.map(exercise, ExerciseDto.class);
    }

    @Override
    public List<MuscleExerciseWithMuscleDto> findAllByMuscleId(UUID id) {
        return muscleExerciseRepository.findAllByMuscleId(id).stream()
                .map(me -> modelMapper.map(me, MuscleExerciseWithMuscleDto.class))
                .toList();
    }

    @Override
    public ExerciseDto addExercise(RequestExerciseDto exerciseDto) {
        if (!isNull(exerciseDto)){
            return modelMapper.map(exerciseRepository.save(
                    modelMapper.map(exerciseDto, Exercise.class)),
                    ExerciseDto.class);
        } else {
            throw new RequestNotValidException("L'elemento passato non è valido per l'aggiunta");
        }
    }

    private boolean isNull(RequestExerciseDto exerciseDto) {
        return exerciseDto == null;
    }

    @Override
    public ExerciseDto updateExercise(UUID id, ExerciseDto exerciseDto) {

        Exercise exercise = exerciseRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("Nessun elemento presente con id " + id)
        );

        if (exerciseDto == null) {
            throw new RequestNotValidException("L'oggetto passato non è valido per l'update");
        }

        exercise.setNome(exerciseDto.getNome());
        exercise.setCategoria(exerciseDto.getCategoria());
        exercise.setModalita(exerciseDto.getModalita());
        exercise.setDifficolta(exerciseDto.getDifficolta());
        exercise.setDescrizioneGenerale(exerciseDto.getDescrizioneGenerale());
        exercise.setRichiedeAttrezzatura(exerciseDto.isRichiedeAttrezzatura());
        exercise.setAttrezzaturaOpzionale(exerciseDto.getAttrezzaturaOpzionale());
        exercise.setVideoDimostrativoUrl(exerciseDto.getVideoDimostrativoUrl());
        exercise.setImmagineAnteprimaUrl(exerciseDto.getImmagineAnteprimaUrl());
        exercise.setActive(exerciseDto.getIsActive());
        exercise.setCreatoDa(exerciseDto.getCreatoDa());

        Exercise updated = exerciseRepository.save(exercise);
        return modelMapper.map(updated, ExerciseDto.class);
    }


    @Override
    public ExerciseDto deleteById(UUID id) {
        Exercise found = exerciseRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("Nessun elemento presente con id " + id)
        );

        exerciseRepository.delete(found);

        return modelMapper.map(found, ExerciseDto.class);
    }
}
