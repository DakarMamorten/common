package com.wsh.domain;

import com.wsh.domain.dto.FilmDto;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
  private Set<Category> categories = new HashSet<>();

  @ManyToMany(cascade = {
      CascadeType.PERSIST,
      CascadeType.MERGE
  })
  @JoinTable(name = "film_actor",
      joinColumns = @JoinColumn(name = "actor_id"),
      inverseJoinColumns = @JoinColumn(name = "film_id")
  )
  private Set<Actor> actors = new HashSet<>();

  public String getCategoriesString() {
    return categories
        .stream()
        .map(Category::getName)
        .collect(Collectors.joining(", "));
  }
  public String getActorsString() {
    return actors
        .stream()
        .map(Actor::getFirstName)
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
}
