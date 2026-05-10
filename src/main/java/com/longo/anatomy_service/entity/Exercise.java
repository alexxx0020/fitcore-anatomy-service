package com.longo.anatomy_service.entity;

import com.longo.anatomy_service.enums.Categoria;
import com.longo.anatomy_service.enums.Difficolta;
import com.longo.anatomy_service.enums.Modalita;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@Data
@Table(name = "EXERCISE")
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "exercise_id")
    private UUID exerciseId;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Enumerated(EnumType.STRING)
    private Modalita modalita;

    @Enumerated(EnumType.STRING)
    private Difficolta difficolta;

    @Column(name = "descrizione_generale")
    private String descrizioneGenerale;

    @Column(name = "richiede_attrezzatura")
    private boolean richiedeAttrezzatura;

    @Column(name = "attrezzatura_opzionale")
    private String[] attrezzaturaOpzionale;

    @Column(name = "video_dimostrativo_url")
    private String videoDimostrativoUrl;

    @Column(name = "immagine_anteprima_url")
    private String immagineAnteprimaUrl;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "creato_da")
    private UUID creatoDa;

    @OneToMany(mappedBy = "exercise", fetch = FetchType.LAZY)
    private List<MuscleExcercise> muscles = new ArrayList<>();
}
