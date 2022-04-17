CREATE TABLE book_author
(
    book_id   BIGINT,
    author_id BIGINT,
    CONSTRAINT pk_book_author PRIMARY KEY (book_id, author_id),
    CONSTRAINT fk_book_author_book_id FOREIGN KEY (book_id) REFERENCES book(id),
    CONSTRAINT fk_book_author_author_id FOREIGN KEY (author_id) REFERENCES author(id)
);