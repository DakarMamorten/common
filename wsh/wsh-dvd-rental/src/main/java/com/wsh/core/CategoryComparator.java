package com.wsh.core;

import com.wsh.domain.Category;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class CategoryComparator {

  @EqualsAndHashCode
  @AllArgsConstructor
  @Getter
  static class Key {

    String name;
    Direction dir;
  }

  static Map<Key, Comparator<Category>> map = new HashMap<>();

  static {
    map.put(new Key("id", Direction.asc), Comparator.comparing(Category::getCategoryId));
    map.put(new Key("id", Direction.desc), Comparator.comparing(Category::getCategoryId)
        .reversed());
    map.put(new Key("name", Direction.asc), Comparator.comparing(Category::getName));
    map.put(new Key("name", Direction.desc), Comparator.comparing(Category::getName)
                                                       .reversed());

  }

  public static Comparator<Category> getComparator(String name, Direction dir) {
    return map.get(new Key(name, dir));
  }

}
