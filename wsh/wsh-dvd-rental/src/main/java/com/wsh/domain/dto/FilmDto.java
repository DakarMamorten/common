package com.wsh.domain.dto;

import java.util.Set;
import lombok.Data;

@Data
public class FilmDto {

  private String title;
  private String description;
  private String releaseYear;
  private Integer rentalDuration;
  private Double rentalRate;
  private Integer filmLength;
  private Double replacementCost;
  private Set<Long> categoryIds;
}
