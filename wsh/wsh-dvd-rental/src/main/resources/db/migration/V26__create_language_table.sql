CREATE TABLE language
(
    language_id BIGSERIAL,
    name        VARCHAR(20) NOT NULL,
    last_update TIMESTAMP,
    CONSTRAINT language_language_id_pk PRIMARY KEY (language_id)
);
