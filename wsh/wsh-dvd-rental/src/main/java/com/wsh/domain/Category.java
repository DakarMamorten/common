package com.wsh.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;
  private String name;
  private LocalDateTime lastUpdate = LocalDateTime.now();

  @ManyToMany(mappedBy = "categories")
  private Set<Film> films = new HashSet<>();

  public Category(String name) {
    this.name = name;
  }
}
