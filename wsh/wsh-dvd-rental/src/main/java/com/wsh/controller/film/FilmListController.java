package com.wsh.controller.film;

import com.wsh.service.CategoryService;
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
  private final CategoryService categoryService;

  @GetMapping
  public String list(
      final Model model,
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @PageableDefault(value = 10, page = 0, sort = "filmId") Pageable pageable) {
    model.addAttribute("films", filmService.findAll(pageable));
    model.addAttribute("categories", categoryService.findAll());
    return "/film/list";
  }

}
