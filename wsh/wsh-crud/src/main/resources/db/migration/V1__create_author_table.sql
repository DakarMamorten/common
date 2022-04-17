CREATE TABLE author
(
    id   BIGSERIAL,
    name VARCHAR NOT NULL,
    CONSTRAINT pk_author_id PRIMARY KEY (id)

)