package com.wsh.controller.category;

import com.wsh.core.Page;
import com.wsh.core.PagingRequest;
import com.wsh.domain.Category;
import com.wsh.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categories")
@RequiredArgsConstructor
public class CategoryRestController {

  private final CategoryService categoryService;

  @PostMapping
  public Page<Category> list(@RequestBody PagingRequest pagingRequest) {
    return categoryService.getCategories(pagingRequest);
  }

}
