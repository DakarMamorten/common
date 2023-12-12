CREATE TABLE country(
    country_id BIGSERIAL,
    country_title varchar,
    last_date timestamp,
    CONSTRAINT country_id_pk PRIMARY KEY (country_id)
);