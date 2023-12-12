package com.wsh.controller.actor;

import com.wsh.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/actor")
@RequiredArgsConstructor
public class ActorEditController {

  private final ActorService actorService;

  @PostMapping("/update")
  public String update( final @RequestParam("actorId") Long actorId, final  String actorFirstName, final String actorLastName) {
    actorService.update(actorId, actorFirstName, actorLastName);
    return "redirect:/actor/list";
  }
}
