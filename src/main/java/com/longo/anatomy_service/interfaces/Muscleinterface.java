package com.longo.anatomy_service.interfaces;

import com.longo.anatomy_service.dto.MuscleDto;

import java.util.List;
import java.util.UUID;

public interface Muscleinterface {

    List<MuscleDto> findAll();
    MuscleDto findById(UUID uuid);
}
