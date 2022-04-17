package com.wsh.controller.author;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author/list")
public class AuthorListController {

  @GetMapping
  public String listAuthor() {
    return "/author/list";
  }

}
