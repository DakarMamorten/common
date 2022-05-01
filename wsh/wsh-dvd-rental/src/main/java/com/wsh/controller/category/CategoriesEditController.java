package com.wsh.controller.category;

import com.wsh.domain.Category;
import com.wsh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category/update")
@RequiredArgsConstructor
public class CategoriesEditController {

  private final CategoryService categoryService;

  @GetMapping
  public String getForUpdateAuthor(final @RequestParam Long id, final Model model) {
    final Category category = categoryService.findById(id);
    model.addAttribute("category", category);
    return "/category/update";
  }

  @PostMapping
  public String updateAuthor(final @RequestParam Long authorId, final @RequestParam String authorName) {
    categoryService.update(authorId, authorName);
    return "redirect:/category/list";
  }
}
