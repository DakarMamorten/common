package com.wsh.controller.category;

import com.wsh.service.CategoryService;
import javax.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/category/update")
@RequiredArgsConstructor
public class CategoriesEditController {

  private final CategoryService categoryService;

//  @GetMapping
//  public String getForUpdate(final @RequestParam Long id, final Model model) {
//    final Category category = categoryService.findById(id);
//    model.addAttribute("category", category);
//    return "/category/update";
//  }

  @PostMapping("/{categoryId}")
  public String update(final @PathParam("categoryId") Long categoryId, final @RequestParam String categoryName) {
    categoryService.update(categoryId, categoryName);
    return "redirect:/category/list";
  }
}
