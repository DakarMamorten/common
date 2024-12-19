CREATE TABLE inventory
(
    inventory_id BIGSERIAL,
    film_id      BIGINT ,
    store_id     BIGINT ,
    last_update  TIMESTAMP,
    CONSTRAINT inventory_inventory_id_pk PRIMARY KEY (inventory_id),
    CONSTRAINT inventory_id_store_id_fk FOREIGN KEY (film_id)
        REFERENCES film,
    CONSTRAINT inventory_inventory_id_store_id_fk FOREIGN KEY (store_id)
        REFERENCES store
);
