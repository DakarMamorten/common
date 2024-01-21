CREATE TABLE payment
(
    payment_id   BIGSERIAL,
    amount       DOUBLE PRECISION NOT NULL,
    payment_date timestamp NOT NULL,
    last_update  timestamp,
    customer_id BIGINT NOT NULL,
    CONSTRAINT payment_id_pk PRIMARY KEY (payment_id),
    CONSTRAINT payment_customer_fk FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);

