CREATE TABLE city_code
(
    id   BIGSERIAL,
    code VARCHAR,
    admin_code_id BIGINT,
CONSTRAINT city_code_id_pk PRIMARY KEY (id),
CONSTRAINT city_code_admin_code_id_fk FOREIGN KEY (admin_code_id) REFERENCES admin_code(id)
);