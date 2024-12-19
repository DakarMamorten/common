CREATE TABLE staff
(
    staff_id    BIGSERIAL,
    first_name  VARCHAR(45) NOT NULL,
    last_name   VARCHAR(45) NOT NULL,
    address_id  BIGINT,
    email       VARCHAR(50),
    store_id    BIGINT,
    active      BOOLEAN DEFAULT TRUE,
    username    VARCHAR(16) NOT NULL,
    password    VARCHAR(40),
    last_update TIMESTAMP,
    CONSTRAINT staff_staff_id_pk primary key (staff_id),
    CONSTRAINT staff_staff_id_address_id_fk FOREIGN KEY (address_id)
        REFERENCES address,
    CONSTRAINT staff_store_id_address_id_fk FOREIGN KEY (store_id)
        REFERENCES store

);
