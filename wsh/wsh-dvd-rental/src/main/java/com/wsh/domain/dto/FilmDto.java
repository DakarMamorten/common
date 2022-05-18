package com.wsh.domain.dto;

import lombok.Data;

import java.util.Set;

@Data
public class FilmDto {

  private Long filmId;
  private String title;
  private String description;
  private String releaseYear;
  private Integer rentalDuration;
  private Double rentalRate;
  private Integer filmLength;
  private Double replacementCost;
  private Set<Long> categoryIds;
  private Set<Long> actorIds;
}
