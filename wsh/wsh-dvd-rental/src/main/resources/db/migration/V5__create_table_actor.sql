CREATE TABLE IF NOT EXISTS actor (
    actor_id BIGSERIAL,
    first_name VARCHAR NOT NULL,
    last_name VARCHAR NOT NULL,
    last_update TIMESTAMP,
    CONSTRAINT actor_pk PRIMARY KEY (actor_id));