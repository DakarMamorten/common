CREATE TABLE IF NOT EXISTS film
(
    film_id          BIGSERIAL,
    title            VARCHAR       NOT NULL,
    description      VARCHAR,
    release_year     VARCHAR(5),
    rental_duration  smallint      NOT NULL DEFAULT 3,
    rental_rate      numeric(4, 2) NOT NULL DEFAULT 4.99,
    film_length      INTEGER,
    replacement_cost numeric(5, 2) NOT NULL DEFAULT 19.99,
    last_update      TIMESTAMP,
    CONSTRAINT film_pk PRIMARY KEY (film_id)
)