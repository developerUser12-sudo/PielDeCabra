CREATE TABLE documentales (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    sinopsis VARCHAR(100) NOT NULL,
    ano_produccion INTEGER NOT NULL,
    cartel VARCHAR(255) NOT NULL,
    iframe VARCHAR(255) NOT NULL,
    duracion INTEGER NOT NULL
);