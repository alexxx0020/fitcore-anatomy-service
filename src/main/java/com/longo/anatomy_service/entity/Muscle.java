package com.longo.anatomy_service.entity;

import com.longo.anatomy_service.enums.GruppoMuscolare;
import com.longo.anatomy_service.enums.Lato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "muscle")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Muscle {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "muscle_id")
    private UUID muscleId;

    @Column(name = "nome_comune")
    private String nomeComune;

    @Column(name = "nome_scientifico")
    private String nomeScientifico;

    @Column(name = "descrizione_anatomica")
    private String descrizioneAnatomica;

    @Column(name = "origine")
    private String origine;

    @Column(name = "inserzione")
    private String inserzione;

    @Column(name = "funzione_primaria")
    private String funzionePrimaria;

    @Column(name = "gruppo_muscolare")
    @Enumerated(EnumType.STRING)
    private GruppoMuscolare gruppoMuscolare;

    @Column(name = "lato")
    @Enumerated(EnumType.STRING)
    private Lato lato;

    @Column(name = "mesh_identifier")
    private String meshIdentifier;

    @Column(name = "colore_evidenziazione")
    private String coloreEvidenziazione;

    @Column(name = "thumbnail_url")
    private String thumbnailUrl;

    @OneToMany(mappedBy = "muscle", fetch = FetchType.LAZY)
    private List<MuscleExcercise> exercises = new ArrayList<>();
}
