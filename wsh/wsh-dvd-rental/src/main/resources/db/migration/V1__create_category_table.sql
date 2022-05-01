CREATE TABLE category
(
    category_id BIGSERIAL,
    name        VARCHAR(25) NOT NULL,
    last_update TIMESTAMP,
    CONSTRAINT category_pk PRIMARY KEY (category_id)

);