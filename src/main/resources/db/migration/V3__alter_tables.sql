ALTER TABLE muscle
    ALTER COLUMN origine TYPE varchar(255),
    ALTER COLUMN inserzione TYPE varchar(255),
    ALTER COLUMN funzione_primaria TYPE varchar(255),
    ALTER COLUMN nome_comune TYPE varchar(100),
    ALTER COLUMN nome_scientifico TYPE varchar(100);

ALTER TABLE exercise
    ALTER COLUMN nome TYPE varchar(100),
    ALTER COLUMN descrizione_generale TYPE varchar(500);