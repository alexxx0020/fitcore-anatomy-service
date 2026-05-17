package com.longo.anatomy_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.longo.anatomy_service.enums.Categoria;
import com.longo.anatomy_service.enums.Difficolta;
import com.longo.anatomy_service.enums.Modalita;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class RequestExerciseDto {

    @NotBlank(message = "Il nome è obbligatorio")
    private String nome;

    @NotNull(message = "La categoria è obbligatoria")
    private Categoria categoria;

    @NotNull(message = "La modalità è obbligatoria")
    private Modalita modalita;

    @NotNull(message = "La difficoltà è obbligatoria")
    private Difficolta difficolta;
    private String descrizioneGenerale;

    @NotNull
    private boolean richiedeAttrezzatura;
    private String[] attrezzaturaOpzionale;

    private String videoDimostrativoUrl;

    private String immagineAnteprimaUrl;

    @JsonProperty("isActive")
    private Boolean isActive;
    private UUID creatoDa;
}
