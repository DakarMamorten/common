package com.wsh.controller.category;

import com.wsh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/category/list")
@RequiredArgsConstructor
public class CategoryListController {

  private final CategoryService categoryService;

  @GetMapping
  public String list(
      final Model model,
      @RequestParam(value = "page", required = false, defaultValue = "0") int page,
      @PageableDefault(value = 10, page = 0, sort = "categoryId") Pageable pageable) {
    model.addAttribute("categories", categoryService.findAll(pageable));
    return "category/list";
  }

}
