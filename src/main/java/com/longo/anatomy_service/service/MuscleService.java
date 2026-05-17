package com.longo.anatomy_service.service;

import com.longo.anatomy_service.dto.MuscleDto;
import com.longo.anatomy_service.dto.MuscleExerciseWithExerciseDto;
import com.longo.anatomy_service.dto.RequestMuscleDto;
import com.longo.anatomy_service.entity.Muscle;
import com.longo.anatomy_service.exception.ItemNotFoundException;
import com.longo.anatomy_service.exception.RequestNotValidException;
import com.longo.anatomy_service.interfaces.Muscleinterface;
import com.longo.anatomy_service.repository.MuscleExerciseRepository;
import com.longo.anatomy_service.repository.MuscleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public MuscleDto findById(UUID id) {
        Muscle muscle = muscleRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("Nessun elemento presente con id " + id)
        );

        return modelMapper.map(muscle, MuscleDto.class);
    }

    @Override
    public List<MuscleExerciseWithExerciseDto> findAllByExerciseId(UUID id) {
        return muscleExerciseRepository.findAllByExerciseId(id).stream()
                .map(me -> modelMapper.map(me, MuscleExerciseWithExerciseDto.class))
                .toList();
    }

    @Override
    public MuscleDto addMuscle(RequestMuscleDto muscleDto) {
        if (!isNull(muscleDto)){
            Muscle muscle = muscleRepository.save(modelMapper.map(muscleDto, Muscle.class));

            return modelMapper.map(muscle, MuscleDto.class);
        } else {
            throw new RequestNotValidException("L'elemento passato non è valido, non può essere aggiunto");
        }
    }

    private boolean isNull(RequestMuscleDto muscleDto) {
        return muscleDto == null;
    }

    @Override
    public MuscleDto updateMuscle(UUID id, RequestMuscleDto muscleDto) {

        Muscle muscle = muscleRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("Nessun elemento presente con id " + id)
        );

        if (muscleDto == null) {
            throw new RequestNotValidException("L'oggetto passato non è valido per l'update");
        }

        muscle.setLato(muscleDto.getLato());
        muscle.setInserzione(muscleDto.getInserzione());
        muscle.setColoreEvidenziazione(muscleDto.getColoreEvidenziazione());
        muscle.setOrigine(muscleDto.getOrigine());
        muscle.setDescrizioneAnatomica(muscleDto.getDescrizioneAnatomica());
        muscle.setFunzionePrimaria(muscleDto.getFunzionePrimaria());
        muscle.setGruppoMuscolare(muscleDto.getGruppoMuscolare());
        muscle.setNomeComune(muscleDto.getNomeComune());
        muscle.setMeshIdentifier(muscleDto.getMeshIdentifier());
        muscle.setNomeScientifico(muscleDto.getNomeScientifico());
        muscle.setThumbnailUrl(muscleDto.getThumbnailUrl());

        Muscle saved = muscleRepository.save(muscle);

        return modelMapper.map(saved, MuscleDto.class);
    }

    @Override
    @Transactional
    public MuscleDto deleteById(UUID id) {
        Muscle found = muscleRepository.findById(id).orElseThrow(
                () -> new ItemNotFoundException("Nessun elemento presente con id " + id)
        );

        if (!found.getExercises().isEmpty()){
            throw new RequestNotValidException("Impossibile completare la richiesta, sono presenti" +
                    " " + found.getExercises().size() + " relazioni attive. Rimuovile prima di procedere");
        }

        muscleRepository.delete(found);

        return modelMapper.map(found, MuscleDto.class);
    }
}
