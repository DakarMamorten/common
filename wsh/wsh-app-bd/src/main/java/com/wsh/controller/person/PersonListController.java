package com.wsh.controller.person;

import com.wsh.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sergey Manko
 */
@Controller
@RequestMapping("/person")
public class PersonListController {

  private final PersonService personService;

  public PersonListController(PersonService personService) {
    this.personService = personService;
  }

  @GetMapping("/list")
  public String list(final Model model) {
    model.addAttribute("persons", personService.findAll());
    return "person/list";
  }
}
