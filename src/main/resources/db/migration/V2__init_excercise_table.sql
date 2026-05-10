create TYPE categoria AS ENUM (
    'PALESTRA',
    'CALISTHENICS',
    'PILATES',
    'RIABILITAZIONE',
    'YOGA',
    'STRETCHING',
    'PLIOMETRIA'
);

create TYPE modalita as ENUM (
    'FORZA',
    'IPERTROFIA',
    'RESISTENZA',
    'MOBILITA',
    'FLESSIBILITA',
    'ESPLOSIVITA'
);

create TYPE difficolta as ENUM (
    'PRINCIPIANTE',
    'INTERMEDIO',
    'AVANZATO',
    'ELITE'
);

CREATE TYPE ruolo_attivazione as ENUM (
    'AGONISTA',
    'SINERGICO',
    'STABILIZZATORE',
    'ANTAGONISTA'
);

create table EXERCISE (
    exercise_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome varchar(55) not null,
    categoria categoria NOT NULL,
    modalita modalita not null,
    difficolta difficolta not null,
    descrizione_generale varchar(255),
    richiede_attrezzatura BOOLEAN NOT NULL DEFAULT FALSE,
    attrezzatura_opzionale TEXT[],
    video_dimostrativo_url varchar(500),
    immagine_anteprima_url varchar(500),
    is_active BOOLEAN,
    creato_da UUID
);

CREATE TABLE Muscle_Exercise (
    muscle_id UUID NOT NULL REFERENCES muscle(muscle_id),
    exercise_id UUID NOT NULL REFERENCES exercise(exercise_id),
    PRIMARY KEY (muscle_id, exercise_id),
    ruolo_attivazione ruolo_attivazione,
    percentuale_attivazione NUMERIC(3,2)
)