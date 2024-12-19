CREATE TABLE film_text
(
    film_id     BIGSERIAL,
    title       VARCHAR(255),
    description TEXT,
    CONSTRAINT film_text_film_id_pk PRIMARY KEY (film_id)
);
