CREATE TABLE IF NOT EXISTS film_actor
(
    actor_id BIGINT,
    film_id  BIGINT,
    CONSTRAINT film_actor_film_id_actor_id_pk PRIMARY KEY (actor_id, film_id),
    CONSTRAINT film_actor_actor_id_fk FOREIGN KEY (actor_id) REFERENCES actor,
    CONSTRAINT film_actor_film_id_fk FOREIGN KEY (film_id) REFERENCES film
);