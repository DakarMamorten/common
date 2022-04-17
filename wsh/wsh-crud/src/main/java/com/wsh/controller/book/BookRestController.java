package com.wsh.controller.book;

import com.wsh.core.Page;
import com.wsh.core.PagingRequest;
import com.wsh.domain.Book;
import com.wsh.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookRestController {

  private final BookService bookService;

  @PostMapping
  public Page<Book> list(@RequestBody PagingRequest pagingRequest) {
    return bookService.getBooks(pagingRequest);
  }
}
