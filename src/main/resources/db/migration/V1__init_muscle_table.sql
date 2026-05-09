CREATE TYPE lato as ENUM (
    'DESTRO',
    'SINISTRO',
    'BILATERALE'
);

CREATE TYPE gruppo_muscolare AS ENUM (
    'PETTO',
    'DORSO',
    'SPALLE',
    'TRAPEZI',
    'BRACCIA',
    'BICIPITI',
    'TRICIPITI',
    'AVAMBRACCI',
    'ADDOME',
    'GLUTEI',
    'GAMBE',
    'QUADRICIPITI',
    'FEMORALI',
    'POLPACCI'
);

create table MUSCLE (
    muscle_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome_comune varchar(50) not null,
    nome_scientifico varchar,
    descrizione_anatomica varchar,
    origine varchar(55),
    inserzione varchar(55),
    funzione_primaria varchar(50),
    gruppo_muscolare gruppo_muscolare not null,
    lato lato,
    mesh_identifier varchar(55) unique,
    colore_evidenziazione varchar(7),
    thumbnail_url varchar(500)
);
