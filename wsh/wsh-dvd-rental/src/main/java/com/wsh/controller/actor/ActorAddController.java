package com.wsh.controller.actor;

import com.wsh.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorAddController {

  private final ActorService actorService;

  @PostMapping("/add")
  public String add(final String actorFirstName, final String actorLastName) {
    actorService.add(actorFirstName, actorLastName);
    return "redirect:/actor/list";
  }

}
