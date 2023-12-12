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
public class ActorDeleteController {

  private final ActorService actorService;

  @PostMapping("/delete")
  public String delete(final @RequestParam("actorId") Long actorId) {
    actorService.delete(actorId);
    return "redirect:/actor/list";
  }
}
