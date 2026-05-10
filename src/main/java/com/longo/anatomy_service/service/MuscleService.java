package com.longo.anatomy_service.service;

import com.longo.anatomy_service.dto.MuscleDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.entity.Muscle;
import com.longo.anatomy_service.exception.ItemNotFoundException;
import com.longo.anatomy_service.interfaces.Muscleinterface;
import com.longo.anatomy_service.repository.MuscleExerciseRepository;
import com.longo.anatomy_service.repository.MuscleRepository;
import com.sun.java.accessibility.util.Translator;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MuscleService implements Muscleinterface {

    private final MuscleRepository muscleRepository;
    private final ModelMapper modelMapper;
    private final MuscleExerciseRepository muscleExerciseRepository;


    @Override
    public List<MuscleDto> findAll() {

        return muscleRepository.findAll()
                .stream()
                .map(muscle -> modelMapper.map(muscle, MuscleDto.class))
                .toList();
    }

    @Override
    public MuscleDto findById(UUID uuid) {
        Muscle muscle = muscleRepository.findById(uuid).orElseThrow(
                () -> new ItemNotFoundException("Nessun elemento presente con questo ID")
        );

        return modelMapper.map(muscle, MuscleDto.class);
    }

    @Override
    public List<MuscleExerciseWithExerciseDto> findAllByExerciseId(UUID id) {
        return muscleExerciseRepository.findAllByExerciseId(id).stream()
                .map(me -> modelMapper.map(me, MuscleExerciseWithExerciseDto.class))
                .toList();
    }
}
