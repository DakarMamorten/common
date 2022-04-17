package com.wsh.service;

import com.wsh.core.BookComparator;
import com.wsh.core.Column;
import com.wsh.core.Order;
import com.wsh.core.Page;
import com.wsh.core.PagingRequest;
import com.wsh.domain.Book;
import com.wsh.repository.BookRepository;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

  private final BookRepository bookRepository;

  public BookService(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  private static final Comparator<Book> EMPTY_COMPARATOR = (e1, e2) -> 0;


  public Page<Book> getBooks(PagingRequest pagingRequest) {
    List<Book> books = bookRepository.findAll();
    if (books.isEmpty()) {
      return new Page<>();
    }
    return getPage(books, pagingRequest);

  }

  private Page<Book> getPage(List<Book> books, PagingRequest pagingRequest) {
    List<Book> filtered = books.stream()
        .sorted(sortBooks(pagingRequest))
        .filter(filterBooks(pagingRequest))
        .skip(pagingRequest.getStart())
        .limit(pagingRequest.getLength())
        .collect(Collectors.toList());

    long count = books.stream()
        .filter(filterBooks(pagingRequest))
        .count();

    Page<Book> page = new Page<>(filtered);
    page.setRecordsFiltered((int) count);
    page.setRecordsTotal((int) count);
    page.setDraw(pagingRequest.getDraw());

    return page;
  }

  private Predicate<Book> filterBooks(PagingRequest pagingRequest) {
    if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch()
        .getValue())) {
      return book -> true;
    }

    String value = pagingRequest.getSearch()
        .getValue();

    return books -> books.getIsbn()
        .toLowerCase()
        .contains(value)
        || books.getTitle()
        .toLowerCase()
        .contains(value);
  }

  private Comparator<Book> sortBooks(PagingRequest pagingRequest) {
    if (pagingRequest.getOrder() == null) {
      return EMPTY_COMPARATOR;
    }

    try {
      Order order = pagingRequest.getOrder()
          .get(0);

      int columnIndex = order.getColumn();
      Column column = pagingRequest.getColumns()
          .get(columnIndex);

      Comparator<Book> comparator = BookComparator.getComparator(column.getData(), order.getDir());
      if (comparator == null) {
        return EMPTY_COMPARATOR;
      }

      return comparator;

    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }

    return EMPTY_COMPARATOR;
  }

}
