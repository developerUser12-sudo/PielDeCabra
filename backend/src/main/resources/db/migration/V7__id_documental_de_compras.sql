
ALTER TABLE compras
DROP CONSTRAINT IF EXISTS fk_compras_documental;

ALTER TABLE compras
DROP COLUMN IF EXISTS id_documental;