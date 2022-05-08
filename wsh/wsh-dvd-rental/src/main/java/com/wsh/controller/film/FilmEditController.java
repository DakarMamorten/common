package com.wsh.controller.film;

import com.wsh.domain.dto.FilmDto;
import com.wsh.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/film/update")
@RequiredArgsConstructor
public class FilmEditController {

  private final FilmService filmService;

  @PostMapping
  public String update(final FilmDto dto) {
    filmService.update(dto);
    return "redirect:/film/list";
  }
}
