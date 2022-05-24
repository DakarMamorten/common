CREATE TABLE frippery
(
    id BIGSERIAL,
    material VARCHAR,
    approximate_weight BIGINT,
    incut varchar,
    brand VARCHAR,
    metal_type BIGINT,
    CONSTRAINT frippery_id_pk PRIMARY KEY (id)
);