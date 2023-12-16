create table customer
(
    customer_id BIGSERIAL,
    first_name  varchar(45) not null,
    last_name   varchar(45) not null,
    email       varchar(50) not null,
    address_id  BIGINT    not null,
    create_date timestamp        not null,
    last_update timestamp,
    active      boolean default true,
    CONSTRAINT customer_id_pk PRIMARY KEY (customer_id),
    CONSTRAINT fk_customer_address FOREIGN KEY (address_id)
        REFERENCES address (address_id)
);

create index idx_fk_address_id
    on customer (address_id);


create index idx_last_name
    on customer (last_name);


