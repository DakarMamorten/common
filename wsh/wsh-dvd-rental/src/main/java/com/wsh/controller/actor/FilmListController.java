package com.wsh.controller.actor;

import com.wsh.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/film/list")
@RequiredArgsConstructor
public class FilmListController {

  private final FilmService filmService;

  @GetMapping
  public String list(
      final Model model,
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @PageableDefault(value = 10, page = 0, sort = "filmId") Pageable pageable) {
    model.addAttribute("films", filmService.findAll(pageable));
    return "/film/list";
  }

}
