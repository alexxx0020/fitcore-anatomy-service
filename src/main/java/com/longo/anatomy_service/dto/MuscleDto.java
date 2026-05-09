package com.longo.anatomy_service.dto;

import com.longo.anatomy_service.enums.GruppoMuscolare;
import com.longo.anatomy_service.enums.Lato;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
public class MuscleDto {

    private UUID muscleId;

    private String nomeComune;

    private String nomeScientifico;

    private String descrizioneAnatomica;

    private String origine;

    private String inserzione;

    private String funzionePrimaria;

    private GruppoMuscolare gruppoMuscolare;

    private Lato lato;

    private String meshIdentifier;

    private String coloreEvidenziazione;

    private String thumbnailUrl;
}
