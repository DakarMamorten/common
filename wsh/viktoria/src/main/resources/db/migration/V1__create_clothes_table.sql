CREATE TABLE clothes
(
    id       BIGSERIAL,
    season   varchar,
    material varchar,
    color    varchar,
    CONSTRAINT clothes_id_pk PRIMARY KEY (id)
);