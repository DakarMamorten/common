package com.wsh.controller.author;

import com.wsh.domain.Author;
import com.wsh.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/author/update")
@RequiredArgsConstructor
public class AuthorEditController {

  private final AuthorService authorService;

  @GetMapping
  public String getForUpdateAuthor(final @RequestParam Long id, final Model model) {
    final Author author = authorService.findById(id);
    model.addAttribute("author", author);
    return "/author/update";
  }

  @PostMapping
  public String updateAuthor(final @RequestParam Long authorId, final @RequestParam String authorName) {
    authorService.update(authorId, authorName);
    return "redirect:/author/list";
  }
}
