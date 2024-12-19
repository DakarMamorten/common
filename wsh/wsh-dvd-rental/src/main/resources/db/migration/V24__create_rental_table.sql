CREATE TABLE rental
(
    rental_id    BIGSERIAL,
    rental_date  TIMESTAMP NOT NULL,
    inventory_id BIGINT,
    customer_id  BIGINT,
    return_date  TIMESTAMP,
    staff_id     BIGINT,
    last_update  TIMESTAMP,
    CONSTRAINT rental_rental_id_pk PRIMARY KEY (rental_id),
    CONSTRAINT rental_rental_id_inventory_id_fk FOREIGN KEY (inventory_id)
        REFERENCES inventory,
    CONSTRAINT rental_rental_id_customer_id_fk FOREIGN KEY (customer_id)
        REFERENCES customer,
    CONSTRAINT rental_rental_id_staff_id_fk FOREIGN KEY (staff_id)
        REFERENCES staff
);
