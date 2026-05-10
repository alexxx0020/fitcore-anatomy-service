package com.longo.anatomy_service.repository;

import com.longo.anatomy_service.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExerciseRepository extends JpaRepository<Exercise, UUID> {

}
