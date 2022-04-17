package com.wsh.core;

import com.wsh.domain.Author;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AuthorComparator {

  @EqualsAndHashCode
  @AllArgsConstructor
  @Getter
  static class Key {

    String name;
    Direction dir;
  }

  static Map<Key, Comparator<Author>> map = new HashMap<>();

  static {
    map.put(new Key("name", Direction.asc), Comparator.comparing(Author::getName));
    map.put(new Key("name", Direction.desc), Comparator.comparing(Author::getName)
        .reversed());


  }

  public static Comparator<Author> getComparator(String name, Direction dir) {
    return map.get(new Key(name, dir));
  }

}
