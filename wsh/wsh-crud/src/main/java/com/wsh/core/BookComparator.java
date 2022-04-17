package com.wsh.core;

import com.wsh.domain.Book;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BookComparator {
  @EqualsAndHashCode
  @AllArgsConstructor
  @Getter
  static class Key {
    String name;
    Direction dir;
  }

  static Map<BookComparator.Key, Comparator<Book>> map = new HashMap<>();

  static {
    map.put(new BookComparator.Key("isbn", Direction.asc), Comparator.comparing(Book::getIsbn));
    map.put(new BookComparator.Key("isbn", Direction.desc), Comparator.comparing(Book::getIsbn)
        .reversed());

    map.put(new BookComparator.Key("title", Direction.asc), Comparator.comparing(Book::getTitle));
    map.put(new BookComparator.Key("title", Direction.desc), Comparator.comparing(Book::getTitle)
        .reversed());

    map.put(new BookComparator.Key("recommendedPrice", Direction.asc), Comparator.comparing(Book::getRecommendedPrice));
    map.put(new BookComparator.Key("recommendedPrice", Direction.desc), Comparator.comparing(Book::getRecommendedPrice)
        .reversed());

    map.put(new BookComparator.Key("datePublication", Direction.asc), Comparator.comparing(Book::getDatePublication));
    map.put(new BookComparator.Key("datePublication", Direction.desc), Comparator.comparing(Book::getDatePublication)
        .reversed());
  }

  public static Comparator<Book> getComparator(String name, Direction dir) {
    return map.get(new BookComparator.Key(name, dir));
  }
}
