CREATE TABLE IF NOT EXISTS film_category
(
    film_id     BIGINT,
    category_id BIGINT,
    CONSTRAINT film_category_film_id_category_id_pk PRIMARY KEY (film_id, category_id),
    CONSTRAINT film_category_film_id_fk FOREIGN KEY (film_id) REFERENCES film,
    CONSTRAINT film_category_category_id_fk FOREIGN KEY (category_id) REFERENCES category
);