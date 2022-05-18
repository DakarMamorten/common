package com.wsh.controller.film;

import com.wsh.domain.dto.FilmDto;
import com.wsh.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/film")
@RequiredArgsConstructor
public class FilmAddController {

  private final FilmService filmService;

  @PostMapping("/add")
  public String add(final FilmDto dto) {
    filmService.add(dto);
    return "redirect:/film/list";
  }

}
