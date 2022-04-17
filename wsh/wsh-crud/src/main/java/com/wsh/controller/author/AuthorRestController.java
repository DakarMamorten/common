package com.wsh.controller.author;

import com.wsh.core.Page;
import com.wsh.core.PagingRequest;
import com.wsh.domain.Author;
import com.wsh.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorRestController {

  private final AuthorService authorService;

  @PostMapping
  public Page<Author> list(@RequestBody PagingRequest pagingRequest) {
    return authorService.getAuthors(pagingRequest);
  }

}
