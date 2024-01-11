package com.wsh.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.wsh.domain.dto.FilmDto;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *@author "Vladyslav Paun"
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "filmId")
public class Film {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long filmId;
  private String title;
  private String description;
  private String releaseYear;
  private Integer rentalDuration;
  private Double rentalRate;
  private Integer filmLength;
  private Double replacementCost;
  private LocalDateTime lastUpdate = LocalDateTime.now();
  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "film_category",
      joinColumns = @JoinColumn(name = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "category_id")
  )
  @JsonManagedReference("film-category")
  private Set<Category> categories = new HashSet<>();
  @Transient
  private Set<Long> selectedCategories = new HashSet<>();
  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE

  },fetch = FetchType.LAZY)
  @JoinTable(name = "film_actor",
      joinColumns = @JoinColumn(name = "film_id"),
      inverseJoinColumns = @JoinColumn(name = "actor_id")
  )
  @JsonManagedReference("film-actor")
  private Set<Actor> actors = new HashSet<>();
  @Transient
  private Set<Long> selectedActors = new HashSet<>();

  public String getCategoriesString() {
    return categories
        .stream()
        .map(Category::getName)
        .collect(Collectors.joining(", "));
  }

  public String getActorsString() {
    return actors
        .stream()
        .map(a -> a.getFirstName() + " " + a.getLastName())
        .collect(Collectors.joining(", "));
  }

  public static Film of(final FilmDto dto) {
    final Film film = new Film();
    film.setTitle(dto.getTitle());
    film.setDescription(dto.getDescription());
    film.setReleaseYear(dto.getReleaseYear());
    film.setRentalDuration(dto.getRentalDuration());
    film.setRentalRate(dto.getRentalRate());
    film.setFilmLength(dto.getFilmLength());
    film.setReplacementCost(dto.getReplacementCost());
    return film;
  }

  public void addCategories(final List<Category> categories) {
    if (this.categories.isEmpty()) {
      this.categories.addAll(categories);
    } else {
      this.categories.removeIf(c -> !categories.contains(c));
      this.categories.addAll(categories);
    }
  }
}
