CREATE TABLE payment
(
    payment_id   BIGSERIAL,
    amount       DOUBLE PRECISION NOT NULL,
    payment_date timestamp NOT NULL,
    last_update  timestamp,
    CONSTRAINT pk_payment_id PRIMARY KEY (payment_id)
);
