package com.wsh.controller.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book/list")
public class BookListController {

  @GetMapping
  public String listBook(){
    return "/book/list";
  }
}
