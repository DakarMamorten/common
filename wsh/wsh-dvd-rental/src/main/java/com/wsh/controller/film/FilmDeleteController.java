package com.wsh.controller.film;

import com.wsh.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/film/delete")
@RequiredArgsConstructor
public class FilmDeleteController {

  private final FilmService filmService;

  @PostMapping
  public String update(final @RequestParam("filmId") Long filmId) {
    filmService.delete(filmId);
    return "redirect:/film/list";
  }
}
