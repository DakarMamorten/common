package com.wsh.controller.category;

import com.wsh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryAddController {

  private final CategoryService categoryService;

  @PostMapping("/add")
  public String add(final String categoryName) {
    categoryService.add(categoryName);
    return "redirect:/category/list";
  }

}
