package com.wsh.service;

import com.wsh.domain.Book;
import com.wsh.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public void addBook(Book book) {
    bookRepository.save(book);
  }
}
