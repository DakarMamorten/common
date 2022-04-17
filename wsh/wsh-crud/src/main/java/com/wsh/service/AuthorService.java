package com.wsh.service;

import com.wsh.core.AuthorComparator;
import com.wsh.core.Column;
import com.wsh.core.Order;
import com.wsh.core.Page;
import com.wsh.core.PagingRequest;
import com.wsh.domain.Author;
import com.wsh.repository.AuthorRepository;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService {

  private final AuthorRepository authorRepository;

  private static final Comparator<Author> EMPTY_COMPARATOR = (e1, e2) -> 0;


  public Page<Author> getAuthors(PagingRequest pagingRequest) {
    List<Author> authors = authorRepository.findAll();
    if (authors.isEmpty()) {
      return new Page<>();
    }
    return getPage(authors, pagingRequest);


  }

  private Page<Author> getPage(List<Author> authors, PagingRequest pagingRequest) {
    List<Author> filtered = authors.stream()
        .sorted(sortAuthors(pagingRequest))
        .filter(filterAuthors(pagingRequest))
        .skip(pagingRequest.getStart())
        .limit(pagingRequest.getLength())
        .collect(Collectors.toList());

    long count = authors.stream()
        .filter(filterAuthors(pagingRequest))
        .count();

    Page<Author> page = new Page<>(filtered);
    page.setRecordsFiltered((int) count);
    page.setRecordsTotal((int) count);
    page.setDraw(pagingRequest.getDraw());

    return page;
  }

  private Predicate<Author> filterAuthors(PagingRequest pagingRequest) {
    if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch()
        .getValue())) {
      return author -> true;
    }

    String value = pagingRequest.getSearch()
        .getValue();

    return author -> author.getName()
        .toLowerCase()
        .contains(value);
  }

  private Comparator<Author> sortAuthors(PagingRequest pagingRequest) {
    if (pagingRequest.getOrder() == null) {
      return EMPTY_COMPARATOR;
    }

    try {
      Order order = pagingRequest.getOrder()
          .get(0);

      int columnIndex = order.getColumn();
      Column column = pagingRequest.getColumns()
          .get(columnIndex);

      Comparator<Author> comparator = AuthorComparator.getComparator(column.getData(), order.getDir());
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
