package com.longo.anatomy_service.repository;

import com.longo.anatomy_service.entity.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MuscleRepository extends JpaRepository<Muscle, UUID> {
}
