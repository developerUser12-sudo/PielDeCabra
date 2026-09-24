CREATE TABLE compras (
    id BIGSERIAL PRIMARY KEY,
    id_plan BIGINT NOT NULL,
    email VARCHAR(100) NOT NULL,
    token VARCHAR(100) NOT NULL UNIQUE,
    visionados_restantes INTEGER NOT NULL,
    fecha_compra TIMESTAMP NOT NULL,
     CONSTRAINT fk_compras_plan
        FOREIGN KEY (id_plan)
        REFERENCES planes(id)
);