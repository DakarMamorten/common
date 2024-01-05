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
@RequestMapping("/category/delete")
@RequiredArgsConstructor
public class CategoriesDeleteController {

  private final CategoryService categoryService;

  @PostMapping
  public String delete(final @RequestParam("categoryId") Long categoryId) {
    categoryService.delete(categoryId);
    return "redirect:/category/list";
  }
}
