CREATE TABLE book
(
    id                BIGSERIAL,
    isbn              VARCHAR(100) NOT NULL,
    title             VARCHAR      NOT NULL,
    recommended_price NUMERIC,
    date_publication  DATE,
    CONSTRAINT pk_book_id PRIMARY KEY (id)

)