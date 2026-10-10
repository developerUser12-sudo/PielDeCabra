
ALTER TABLE compras
ADD COLUMN stripe_session_id VARCHAR(255);

ALTER TABLE compras
ADD CONSTRAINT uq_compras_stripe_session
UNIQUE (stripe_session_id);