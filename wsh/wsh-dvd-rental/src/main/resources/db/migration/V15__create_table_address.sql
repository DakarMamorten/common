CREATE TABLE address
(
    address_id  BIGSERIAL,
    address     varchar(50),
    address2    varchar(50),
    district    varchar(20),
    city_id     BIGINT,
    postal_code varchar(10),
    phone       varchar(20),
    last_update timestamp,
    CONSTRAINT address_id_pk PRIMARY KEY (address_id),
    CONSTRAINT fk_address_city FOREIGN KEY (city_id)
        REFERENCES city (city_id)
);