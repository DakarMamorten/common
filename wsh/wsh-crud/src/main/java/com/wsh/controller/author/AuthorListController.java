package com.wsh.controller.author;

import com.wsh.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author/list")
@RequiredArgsConstructor
public class AuthorListController {

  private final AuthorRepository authorRepository;

  @GetMapping
  public String listAuthor(final Model model) {
    model.addAttribute("authors", authorRepository.findAll());
    return "/author/list";
  }

}
