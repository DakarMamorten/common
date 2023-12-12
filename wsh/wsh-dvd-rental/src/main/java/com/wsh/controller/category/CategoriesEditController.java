package com.wsh.controller.category;

import com.wsh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/category/update")
@RequiredArgsConstructor
public class CategoriesEditController {

  private final CategoryService categoryService;

  @PostMapping
  public String update(final @RequestParam("categoryId") Long categoryId, final @RequestParam String categoryName) {
    categoryService.update(categoryId, categoryName);
    return "redirect:/category/list";
  }
}
