package com.longo.anatomy_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.longo.anatomy_service.enums.Categoria;
import com.longo.anatomy_service.enums.Difficolta;
import com.longo.anatomy_service.enums.Modalita;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class ExerciseDto {

    private UUID exerciseId;

    private String nome;

    private Categoria categoria;

    private Modalita modalita;

    private Difficolta difficolta;

    private String descrizioneGenerale;

    private boolean richiedeAttrezzatura;

    private String[] attrezzaturaOpzionale;

    private String videoDimostrativoUrl;

    private String immagineAnteprimaUrl;

    @JsonProperty("isActive")
    private Boolean isActive;

    private UUID creatoDa;
}
