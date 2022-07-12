CREATE TABLE city
(
    city_id    BIGSERIAL,
    city_title varchar NOT NULL,
    country_id BIGINT,
    last_update TIMESTAMP,
    CONSTRAINT city_id_pk PRIMARY KEY (city_id),
    CONSTRAINT city_country_id_fk FOREIGN KEY (country_id) REFERENCES country
);