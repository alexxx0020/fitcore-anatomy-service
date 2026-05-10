package com.longo.anatomy_service.dto;

import com.longo.anatomy_service.enums.GruppoMuscolare;
import com.longo.anatomy_service.enums.Lato;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestMuscleDto {

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