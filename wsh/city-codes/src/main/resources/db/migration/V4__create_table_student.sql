CREATE TABLE student
(
    id   BIGSERIAL,
    name VARCHAR,
    age  BIGINT,
    CONSTRAINT student_id_pk PRIMARY KEY (id)
);