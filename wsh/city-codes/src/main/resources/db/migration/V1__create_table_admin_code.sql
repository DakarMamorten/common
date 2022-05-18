CREATE TABLE admin_code
(
    id       BIGSERIAL,
    code     VARCHAR,
    title    VARCHAR,
    title_ua VARCHAR,
        CONSTRAINT admin_code_id_pk PRIMARY KEY (id)
);