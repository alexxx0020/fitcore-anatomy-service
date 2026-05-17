package com.longo.anatomy_service.dto;

import com.longo.anatomy_service.enums.GruppoMuscolare;
import com.longo.anatomy_service.enums.Lato;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestMuscleDto {

    @NotBlank(message = "Il nome comune è obbligatorio")
    private String nomeComune;

    private String nomeScientifico;

    @NotBlank(message = "La descrizione Anatomica è obbligatoria")
    private String descrizioneAnatomica;

    @NotBlank(message = "L'origine è obbligatoria")
    private String origine;

    @NotBlank(message = "L'inserzione è  obbligatoria")
    private String inserzione;

    @NotBlank(message = "La funzione primaria è obbligatoria")
    private String funzionePrimaria;

    @NotNull(message = "Il gruppo muscolare è obbligatorio")
    private GruppoMuscolare gruppoMuscolare;

    @NotNull(message = "Il lato è obbligatorio")
    private Lato lato;

    @NotBlank(message = "il mesh identifier è obbligatorio")
    private String meshIdentifier;

    @NotBlank(message = "il colore di evidenziazione è obbligatorio")
    private String coloreEvidenziazione;

    @NotBlank(message = "obbligatorio")
    private String thumbnailUrl;
}