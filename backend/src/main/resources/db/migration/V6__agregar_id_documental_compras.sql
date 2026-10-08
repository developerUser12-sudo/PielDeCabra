ALTER TABLE compras
ADD COLUMN id_documental BIGINT;

ALTER TABLE compras
ADD CONSTRAINT fk_compras_documental
    FOREIGN KEY (id_documental)
    REFERENCES documentales(id);