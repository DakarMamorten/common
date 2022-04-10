package com.wsh.controller.person;

import com.wsh.domain.Person;
import com.wsh.service.PersonService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonAddController {

  private final PersonService personService;

  @GetMapping("/add")
  public String getPerson(Model model) {
    model.addAttribute("person", new Person());
    return "person/person";
  }

  @PostMapping("/add")
  public String addPerson(@Valid @ModelAttribute Person person, BindingResult result, Model model) {
    if (result.hasErrors()) {
      System.out.println(result.getAllErrors());
      return "person/person";
    }
    model.addAttribute("person", person);
    personService.add(person);
    return "redirect:/person/list";
  }

}
