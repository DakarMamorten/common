package com.wsh.controller.film;

import com.wsh.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/film/update")
@RequiredArgsConstructor
public class FilmEditController {

  private final FilmService filmService;

  @PostMapping
  public String update(final @RequestParam("filmId") Long filmId, final @RequestParam String title, final String description, final String releaseYear,
      final Integer rentalDuration, final Double rentalRate, final Integer filmLength, final Double replacementCost) {
    filmService.update(filmId, title, description, releaseYear, rentalDuration,rentalRate,filmLength,replacementCost);
    return "redirect:/film/list";
  }
}
