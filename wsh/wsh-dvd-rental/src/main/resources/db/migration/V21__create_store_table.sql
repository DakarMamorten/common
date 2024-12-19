CREATE TABLE store
(
    store_id         BIGSERIAL ,
    manager_staff_id BIGINT,
    address_id       BIGINT,
    last_update      TIMESTAMP,
    CONSTRAINT store_store_id_pk primary key (store_id),
    CONSTRAINT store_store_id_address_id_fk FOREIGN KEY (address_id)
        REFERENCES address
);
