package com.wsh.controller.category;

import com.wsh.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author/list")
@RequiredArgsConstructor
public class CategoryListController {

  private final CategoryRepository categoryRepository;

  @GetMapping
  public String listAuthor(final Model model) {
    model.addAttribute("categories", categoryRepository.findAll());
    return "/author/list";
  }

}
