package com.wsh.controller.actor;

import com.wsh.service.ActorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/actor/delete")
@RequiredArgsConstructor
public class ActorDeleteController {

  private final ActorService actorService;

  @PostMapping
  public String update(final @RequestParam("actorId") Long actorId) {
    actorService.delete(actorId);
    return "redirect:/actor/list";
  }
}
