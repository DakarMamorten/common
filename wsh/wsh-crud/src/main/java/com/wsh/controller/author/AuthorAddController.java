package com.wsh.controller.author;

import com.wsh.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
@RequiredArgsConstructor
public class AuthorAddController {

  private final AuthorService authorService;

  @PostMapping("/add")
  public String addAuthor(final String authorName) {
    authorService.add(authorName);
    return "redirect:/author/list";
  }

}
